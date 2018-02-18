package main.asw.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.asw.agents.Agent;

/**
 * @author Pineirin
 * @since 14/02/2017.
 */
class TxtWriter implements ReportWriter {

    private final static Logger log = LoggerFactory.getLogger(TxtWriter.class);

    @Override
    public void writeReport(List<Agent> users) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        for (Agent user : users)
            try {
                fileWriter = new FileWriter("Generated/GeneratedTxt/" + user.getEmail() + ".txt");
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("Greetings: " + user.getName() + ".\n"
                        + "This is your personal information that we have received: \n"
                      //  + "Date of birth: " + user.getDateOfBirth() + ".\n"
                        + "NIF: " + user.getId() + ".\n"
                      //  + "Nationality: " + user.getNationality() + ".\n"
                      //  + "Address: " + user.getAddress() + ".\n"
                        + "\n"
                        + "Your user name is your email: " + user.getEmail() + "\n"
                      //  + "Your password is: " + user.getUnencryptedPass()
                        );
                log.info("Exported user with userId = " + user.getId() + " correctly to TXT format");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
    }
}
