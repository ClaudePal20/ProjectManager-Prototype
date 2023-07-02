package org.example.bibliotecadecodigopmi.scrumlibrary;
import org.example.bibliotecadecodigopmi.gui.PMBOKLibraryGUI;
import org.example.bibliotecadecodigopmi.scrumlibrary.Project;
import org.example.bibliotecadecodigopmi.scrumlibrary.Tarea;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpx.MPXReader;
import net.sf.mpxj.mpx.MPXWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectManager extends PMBOKLibraryGUI {
    private ArrayList<Project> projects = new ArrayList<>();
    private ProjectFile projectFile;
    public void exportToXML(List<Project> projects) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element rootElement = document.createElement("projects");
        document.appendChild(rootElement);
        for (Project project : projects) {
            Element projectElement = document.createElement("project");
            rootElement.appendChild(projectElement);

            Element nameElement = document.createElement("name");
            nameElement.setTextContent(project.getNombre());
            projectElement.appendChild(nameElement);

            Element startDateElement = document.createElement("startDate");
            startDateElement.setTextContent(project.getFechaDeInicio().toString());
            projectElement.appendChild(startDateElement);

            Element endDateElement = document.createElement("endDate");
            endDateElement.setTextContent(project.getFechaDeTerminado().toString());
            projectElement.appendChild(endDateElement);

            Element budgetElement = document.createElement("budget");
            budgetElement.setTextContent(project.getPresupuesto());
            projectElement.appendChild(budgetElement);

            Element managerElement = document.createElement("manager");
            managerElement.setTextContent(project.getManagerDeProyecto());
            projectElement.appendChild(managerElement);

            Element tasksElement = document.createElement("tasks");
            projectElement.appendChild(tasksElement);

            for (Tarea task : project.getTareas()) {
                Element taskElement = document.createElement("task");
                tasksElement.appendChild(taskElement);

                Element taskNameElement = document.createElement("name");
                taskNameElement.setTextContent(task.getNombre());
                taskElement.appendChild(taskNameElement);

                Element taskStartDateElement = document.createElement("startDate");
                taskStartDateElement.setTextContent(task.getFechaDeInicio().toString());
                taskElement.appendChild(taskStartDateElement);

                Element taskEndDateElement = document.createElement("endDate");
                taskEndDateElement.setTextContent(task.getFechaDeTerminado().toString());
                taskElement.appendChild(taskEndDateElement);

                Element taskConcluidoElement = document.createElement("concluido");
                taskConcluidoElement.setTextContent(String.valueOf(task.getCompletado()));
                taskElement.appendChild(taskConcluidoElement);
            }
        }

        // Write the DOM document to the file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("proyectos2.xml"));
        transformer.transform(domSource, streamResult);
    }

    public List<Project> importFromXML(String filename) throws ParserConfigurationException, IOException, SAXException {
        List<Project> projects = new ArrayList<>();
        File inputFile = new File(filename);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("project");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                LocalDate startDate = LocalDate.parse(element.getElementsByTagName("startDate").item(0).getTextContent());
                LocalDate endDate = LocalDate.parse(element.getElementsByTagName("endDate").item(0).getTextContent());
                String budget = element.getElementsByTagName("budget").item(0).getTextContent();
                String manager = element.getElementsByTagName("manager").item(0).getTextContent();
                NodeList taskList = element.getElementsByTagName("task");
                List<Tarea> tareas = new ArrayList<>();
                for (int j = 0; j < taskList.getLength(); j++) {
                    Node taskNode = taskList.item(j);
                    if (taskNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element taskElement = (Element) taskNode;
                        String taskName = taskElement.getElementsByTagName("name").item(0).getTextContent();
                        LocalDate taskStartDate = LocalDate.parse(taskElement.getElementsByTagName("startDate").item(0).getTextContent());
                        LocalDate taskEndDate = LocalDate.parse(taskElement.getElementsByTagName("endDate").item(0).getTextContent());
                        String taskDescription = taskElement.getElementsByTagName("description").item(0).getTextContent();
                        Boolean taskCompleted = Boolean.parseBoolean(taskElement.getElementsByTagName("completed").item(0).getTextContent());
                        Tarea tarea = new Tarea(taskName, taskStartDate, taskEndDate, taskDescription,taskCompleted);
                        tareas.add(tarea);
                    }
                }
                Project project = new Project(name, startDate, endDate, tareas, budget, manager);
                projects.add(project);
            }
        }
        return projects;
    }
    public void eliminarProjecto(Project project) {
        this.projects.remove(project);
    }
    public ProjectFile getProjectFile() {
        if(projectFile== null) {
            projectFile = new ProjectFile();
        }
        return projectFile;
    }
    public List<Project> getProjects() {
        return projects;
    }
    public void exportToMPXJ(List<Project> projects) {
        try {
            ProjectFile projectFile = getProjectFile();
            for (Project project : projects) {
                Task parentTask = projectFile.addTask();
                parentTask.setName(project.getNombre());
                parentTask.setStart(project.getFechaDeInicio());
                parentTask.setFinish(project.getFechaDeTerminado());
                parentTask.setCost(Double.parseDouble(project.getPresupuesto()));
                parentTask.setResourceNames(project.getManagerDeProyecto());
                for (Tarea tarea : project.getTareas()) {
                    Task childTask = parentTask.addTask();
                    childTask.setName(tarea.getNombre());
                    Date date = Date.from(tarea.getFechaDeInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Date date2 = Date.from(tarea.getFechaDeTerminado().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    childTask.setStart(date);
                    childTask.setFinish(date2);
                    childTask.setNotes(tarea.getDescripcion());
                    childTask.setConfirmed(tarea.getCompletado());
                }
                //for(SprintPlanificacion sprint:project.getSprintsPlanificacion()){
                    //Task childTask = parentTask.addTask();
                    //childTask.setSprintID(sprint.getNumero());
                    //childTask.setName(sprint.getNombre());
                    //childTask.setNotes(sprint.getObjetivo());
                    //childTask.setID(sprint.getDuracionEnSemanas());
                    //childTask.set
                //}
            }
            MPXWriter writer = new MPXWriter();

            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                if (selectedFile.exists()) {
                    int response = JOptionPane.showConfirmDialog(null,
                            "El archivo seleccionado ya existe. ¿Desea sobrescribirlo?",
                            "Confirmar sobrescritura", JOptionPane.YES_NO_OPTION);
                    if (response != JOptionPane.YES_OPTION) {
                        return;
                    }
                }

                writer.write(projectFile, filePath);
            }
        } catch (Exception ex) {
            System.out.println("Error exporting MPXJ file: " + ex.getMessage());
        }
    }
    public void importFromMPXJ(String filename) {
        ArrayList<Project> projects = new ArrayList<>();
        try {
            ProjectFile projectFile = new MPXReader().read(filename);
            //Obtener los proyectos
            for (Task proyecto : projectFile.getTasks()) {
                if (proyecto.getName() != null) {
                    if (proyecto.getParentTask() == null) {
                        Project project = new Project(proyecto.getName(), proyecto.getStart() != null ? LocalDate.ofInstant(proyecto.getStart().toInstant(), ZoneId.systemDefault()) : null, proyecto.getFinish() != null ? LocalDate.ofInstant(proyecto.getFinish().toInstant(), ZoneId.systemDefault()) : null, new ArrayList<>(), String.valueOf(proyecto.getCost()), proyecto.getResourceNames());
                        projects.add(project);
                    } else {
                        String projectName = proyecto.getParentTask().getName();
                        Project project = findProjectByName(projects, projectName);
                        if (project != null) {
                            //Agregar tarea
                            Tarea tarea = new Tarea(proyecto.getName(), proyecto.getStart() != null ? LocalDate.ofInstant(proyecto.getStart().toInstant(), ZoneId.systemDefault()) : null, proyecto.getFinish() != null ? LocalDate.ofInstant(proyecto.getFinish().toInstant(), ZoneId.systemDefault()) : null, proyecto.getNotes(),proyecto.getConfirmed());
                            project.agregarTarea(tarea);
                        }
                        //Agregar sprint

                    }
                }
            }
            this.projects = projects;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void SerializarProyectos(){
        try {
            FileOutputStream fileOut = new FileOutputStream("proyectos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(projects);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in proyectos.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void RecuperarProyectos(){
        try {
            FileInputStream fileIn = new FileInputStream("proyectos.ser");
            //Si no aparece el archivo, se crea uno nuevo
            if(fileIn==null){
                System.out.println("Archivo creado.");
                projects = new ArrayList<>();
                return;
            }
            ObjectInputStream in = new ObjectInputStream(fileIn);
            projects = (ArrayList<Project>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Proyectos class not found");
            c.printStackTrace();
        }
    }
    private Project findProjectByName(List<Project> projects, String projectName) {
        for (Project project : projects) {
            if (project.getNombre().equals(projectName)) {
                return project;
            }
        }
        return null;
    }

}
