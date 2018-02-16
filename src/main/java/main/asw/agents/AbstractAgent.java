package main.asw.agents;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.asw.util.Checker;
/**
 * 
 * @author Sergio Faya Fernandez
 *
 */
public abstract class AbstractAgent implements Agent {

	protected String name = null;
	protected String email = null;
	protected  String id = null;
	protected int agentKind = -1;
		
	public AbstractAgent(String name,String email, String id)  {
		checkConstructor(name,email,id);
		this.name = name;
		setEmail(email);
		setId(id);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public int getAgentKind() {
		return agentKind;
	}
	
	private void checkConstructor(String name, String email, String id)  {
		Checker.isNull(name);
		Checker.isEmpty(name);
		Checker.isNull(email);
		Checker.isEmpty(email);
		Checker.isNull(id);
		Checker.isEmpty(id);
	}

	/**
	 * The intend of this method is to make easier the modification of the toString method
	 * The format of the toString will be in JSON object format
	 * {
	 *  extensibleToString()
	 *  location = 'location'
	 *  ,...
	 * }
	 * @return agent common fields without {}
	 */
	protected String extensibleToString() {
		String className = this.getClass().getSimpleName(); 
		return className+ " Name='"+name+"'"
						+ ",Email='"+email+"'"
						+ ",ID='"+id +"'"
						+ ",AgentKind='"+agentKind+"'";
	}
	
	@Override
	public String toString() {
		return "{"+extensibleToString()+"}";
	}
	
	/**
     * This is a copy of a 2017 class called user.
     * @author nicolas
	 * @author MIGUEL
	 * 
	 */
	public void setEmail(String email) {
        if (validateEmail(email))
            this.email = email;
        else
            throw new IllegalArgumentException("The email is not well formed");
    }

	/**
     * This is a copy of a 2017 class called user.
     * @author nicolas
	 * @author MIGUEL
	 * 
	 */
    private boolean validateEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * This is a copy of a 2017 class called user.
     * @author nicolas
	 * @author MIGUEL
	 * 
	 */
    public void setId(String nif) {
        if (validateId(nif))
            this.id = nif;
        else
            throw new IllegalArgumentException("The nif is not well formed");
    }

    /**
     * This is a copy of a 2017 class called user.
     * @author nicolas
	 * @author MIGUEL
     * Template method, is redefined in the sensor as sensor uses another ID 
     * @param nif
     * @return true if the validation is correct, false otherwise
     * 
     */
    protected boolean validateId(String nif) {
        Boolean res = true;
        if (nif.length() == 9) {
            int dni = Integer.parseInt(nif.substring(0, 8));
            String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
            int modulo = dni % 23;
            char letra = juegoCaracteres.charAt(modulo);
            if (nif.charAt(8) != letra)
                res = false;
        } else {
            res = false;
        }
        return res;
    }
}
