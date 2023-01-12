package Repository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompteurDeClic implements ActionListener
{
    // Compte le nombre de clics
    private int i = 0;

    // L'étiquette pour afficher la valeur du compteur
    private JLabel label;

    // Bouton qui incrémente quand on clique dessus
    private JButton plus;

    // Bouton qui décrémente lorsqu'on clique dessus
    private JButton moins;

    public JPanel getPanel() {
        // Créez le panneau
        JPanel panel = new JPanel();

        // Ajoutez le bouton qui incrémente
        plus = new JButton("+");
        plus.addActionListener(this);
        panel.add(plus);

        // Ajoutez le bouton qui décrémente
        moins = new JButton("-");
        moins.addActionListener(this);
        panel.add(moins);

        // Ajouter le compteur à afficher
        label = new JLabel("" + i);
        panel.add(label);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plus) {
            i++;
            label.setText("" + i);
        }
        else {
            i--;
            label.setText("" + i);
        }
    }


}