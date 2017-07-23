
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

public class Controller implements ActionListener{
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        addActionListeners();
    }

    private void addActionListeners(){
        for (JButton knob : view.knobs) {
            knob.addActionListener(this);
        }
        view.newGame.addActionListener(this);
    }
    private boolean addChoice(Integer field, Value value) {
        model.setChoice(field, value);
        if(model.movesCounter >= 5) {
            if(model.checkBoard()) {
                view.winGame();
                view.endGame();
                return true;
            }
            if(model.movesCounter == 9) {
                view.endGame();
                view.setNoWinner();
            }
        } 
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Value currentPlayer = view.getCurrentPlayerValue(); 

        if (Arrays.asList(view.knobs).contains(e.getSource()) && currentPlayer != null) {
            Integer knobIndex = Arrays.asList(view.knobs).indexOf((JButton)e.getSource());
            ((JButton) e.getSource()).setText(view.getCurrentPlayerString()); 
            view.pack();
            ((JButton) e.getSource()).setEnabled(false); 
            if(!addChoice(knobIndex, currentPlayer)) view.changePlayer();]
        } else if(e.getSource().equals(view.newGame)) {
            this.view.dispose();
            this.view = new View();
            addActionListeners();
            this.model = new Model();
        }
        }
    }
