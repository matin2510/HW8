package nyc.c4q.mustafizurmatin.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EmptyStackException;
import java.util.Stack;

public class First extends AppCompatActivity {

    Button but1;
    EditText text;


    public void inBotton() {
        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First.this, Second.class);
                //\intent.putExtra("input", text.getText().toString());
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "List Of words", Toast.LENGTH_LONG).show();

                editHistory(text.getText().toString());
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        text = (EditText) findViewById(R.id.editText);
        inBotton();
    }

    private static void editHistory(String input) {

        //System.out.print("Input: ");
        System.out.println("Do you want to copy, delete, or undo?");


        Stack<String> stack = new Stack<>();
        stack.push(input);
        String holdsWhatWasDeleted = "";
        Stack<String> undoStack = new Stack<>();
        boolean quit = true;

        //System.out.println(stack.pop());
        switch (input) {
            case "copy":
                stack.push(input);
                System.out.println(stack.toString());
                break;


            case "delete":
                try {
                    undoStack.push(stack.pop());
                    System.out.println(stack.toString());
                    break;


                } catch (EmptyStackException emptyStack) {
                    System.out.println("empty stack ");
                    break;
                }


            case "undo":
                try {
                    stack.push(undoStack.pop());
                    System.out.println(stack.toString());
                    break;
                } catch (EmptyStackException undoS) {
                    System.out.println("nothing to undo ");
                }


            case "quit":
                quit = false;


                break;
        }

    }
}
