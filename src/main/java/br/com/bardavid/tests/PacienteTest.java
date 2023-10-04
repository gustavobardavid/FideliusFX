package br.com.bardavid.tests;
import java.util.List;
import java.util.Scanner;

import java.util.concurrent.CompletableFuture;

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
		
		Scanner scanner = new Scanner(System.in);
		int opcao;
        do {
            System.out.println("1- Testar o cadastro e persistencia\n" +
                    "2- Testar findAll\n" +
                    "0- Sair");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
            		Paciente paciente = new Paciente();
            		Paciente pacienteCadastrado = Cadastrar(paciente);
            		dao.save(pacienteCadastrado);
                    break;
                case 2:
                	List<Paciente> pacientes = dao.findAll();
//                	for (Paciente paciente : pacientes) {
//            			System.out.println(paciente.getNome());
//            		}
                	exibirPacientes(pacientes);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    break;
            }

        } while(opcao != 0);
 
	}
	
	public static void exibirPacientes(List<Paciente> pacientes) {
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
	
	public static Paciente Cadastrar (Paciente paciente) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cadastro de Paciente");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel nameLabel = new JLabel("Nome:");
            JTextField nameField = new JTextField(20);

            JLabel comorLabel = new JLabel("Comorbidade:");
            JTextField comorField = new JTextField(10);

            JButton submitButton = new JButton("Cadastrar");
            

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    String nomePaciente= nameField.getText();
                    paciente.setNome(nomePaciente); 
                    String comorbidadePaciente = comorField.getText();
                    paciente.setComorbidade(comorbidadePaciente);
                    JOptionPane.showMessageDialog(frame,
                            "Cadastro realizado:\nNome: " + paciente.getNome() + "\nComorbidade: " + paciente.getComorbidade());
                    
                }
            });
            
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(comorLabel);
            panel.add(comorField);
            panel.add(submitButton);
            
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
            
        });
        
        return paciente;
    }
}
