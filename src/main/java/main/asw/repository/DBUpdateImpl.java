package main.asw.repository;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import main.asw.agents.Agent;
import main.asw.report.ReportFactory;
import main.asw.report.ReportWriter;

class DBUpdateImpl implements DBUpdate {

    private List<Agent> correctUsers;

    @Override
    public void insert(List<Agent> users) {
        UserDao ud = PersistenceFactory.getUserDAO();
        this.correctUsers = new ArrayList<>();
        for (Agent u : users) {
            if(ud.saveUser(u)) {
                correctUsers.add(u);
            }
        }
    }

    @Override
    public void writeReport() {
        generateDirectories();
        ReportWriter textWriter = ReportFactory.createTxtWriter();
        ReportWriter docxWriter = ReportFactory.createDocxWriter();
        ReportWriter pdfWriter = ReportFactory.createPdfWriter();
        textWriter.writeReport(correctUsers);
        docxWriter.writeReport(correctUsers);
        pdfWriter.writeReport(correctUsers);
    }

    private void generateDirectories() {
        File dir = new File("Generated/GeneratedTxt");
        File dir2 = new File("Generated/GeneratedDocx");
        File dir3 = new File("Generated/GeneratedPdf");

        dir.mkdirs();
        dir2.mkdirs();
        dir3.mkdirs();
    }
}
