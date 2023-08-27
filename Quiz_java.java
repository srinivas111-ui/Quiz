import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
public class Quiz_java extends WindowAdapter implements ActionListener,WindowListener {
    private Label questionLabel;
    private CheckboxGroup optionsGroup;
    private Checkbox optionA, optionB, optionC, optionD;
    private Button nextButton;
    public int currentQuestion = 0;
    int d=0;
    public TextField t;
    int c[]=new int[3];
    // Sample questions and options
    private String[] questions = {
        "What is the capital of U.S.A?",
        "Which planet is known as the Red Planet?",
        "What is 2 + 2*2?"
    };
    
    private String[][] options = {
        {"Washington D.C","Paris", "London", "Madrid"},
        {"Mars", "Venus", "Jupiter", "Saturn"},
        {"6", "4", "5", "7"}
    };
    Frame f=new Frame();
    public Quiz_java() {
        f.setTitle("Online Quiz System");
        f.setSize(500, 500);
        //Panel p=new Panel();
        Panel p1=new Panel();
        questionLabel = new Label(questions[currentQuestion]);
        optionsGroup = new CheckboxGroup();
        optionA = new Checkbox(options[currentQuestion][0], optionsGroup, false);
        optionB = new Checkbox(options[currentQuestion][1], optionsGroup, false);
        optionC = new Checkbox(options[currentQuestion][2], optionsGroup, false);
        optionD = new Checkbox(options[currentQuestion][3], optionsGroup, false);
        nextButton = new Button("Next");
        p1.add(questionLabel);
        p1.add(optionA);
        p1.add(optionB);
        p1.add(optionC);
        p1.add(optionD);
        p1.add(nextButton);
        t=new TextField();
        p1.add(t);
        p1.setLayout(new GridLayout(7,1));
        f.add(p1);
        f.addWindowListener(new WindowAdapter()
    {
        public void windowClosing(WindowEvent e)
        {
            f.dispose();
        }
    });
        nextButton.addActionListener(this);
        f.setBackground(Color.cyan);
        /*add(questionLabel);
        add(optionA);
        add(optionB);
        add(optionC);
        add(optionD);
        add(nextButton);
        */
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            // Check if an option is selected
            if (optionsGroup.getSelectedCheckbox() != null) {
                // Check the answer
                if (optionsGroup.getSelectedCheckbox().getLabel().equals(options[currentQuestion][0])) {
                    c[currentQuestion]=1;
                    d=d+1;
                } else {
c[currentQuestion]=0;
                }
                
                // Move to the next question
                currentQuestion++;
                
                if (currentQuestion < questions.length) {
                    // Update the UI for the next question
                    questionLabel.setText(questions[currentQuestion]);
                    optionA.setLabel(options[currentQuestion][0]);
                    optionB.setLabel(options[currentQuestion][1]);
                    optionC.setLabel(options[currentQuestion][2]);
                    optionD.setLabel(options[currentQuestion][3]);
                } 
                else
                    {
                    t.setText("Congratulations your Score is "+d+" for "+questions.length+"\n Marks score analysis \n"+c[0]+c[1]+c[2]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new Quiz_java();
    }
}
