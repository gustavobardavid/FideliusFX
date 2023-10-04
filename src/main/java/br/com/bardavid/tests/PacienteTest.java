package br.com.bardavid.tests;
import java.util.List;

//Importando swing
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//importando classe q mantem a persistencia
import br.com.bardavid.dao.PacienteDAO;
import br.com.bardavid.model.bean.Paciente;


public class PacienteTest {
	public static void main(String[] args) {
		
		PacienteDAO dao = new PacienteDAO();
		List<Paciente> pacientes = dao.findAll();
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.getNome());
		}
		
		SwingUtilities.invokeLater(() -> {

	            JFrame frame = new JFrame("Dados do Paciente");
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            JPanel panel = new JPanel();
	            
	            panel.setLayout(new GridLayout(3, 2));
	            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
	            frame.getContentPane().add(panel);
	            frame.pack();
	            frame.setLocationRelativeTo(null);
	            frame.setVisible(true);
	            
	            for (Paciente paciente : pacientes) {

	                JPanel pacientePanel = new JPanel();
	                pacientePanel.setLayout(new GridLayout(2, 2)); 
	    
	                JLabel nameLabel = new JLabel("Nome: " + paciente.getNome());
	                JLabel comorLabel = new JLabel("Comorbidade: " + paciente.getComorbidade());
	                
	    
	                pacientePanel.add(nameLabel);
	               
	                pacientePanel.add(comorLabel);
	        
	    
	                panel.add(pacientePanel);
	    
	        
	                panel.add(Box.createVerticalStrut(20));

	            }
		 });
	}
}
