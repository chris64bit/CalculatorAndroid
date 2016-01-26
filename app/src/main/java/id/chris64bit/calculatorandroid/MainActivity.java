package id.chris64bit.calculatorandroid;
// formatdesimal() http://stackoverflow.com/questions/703396/how-to-nicely-format-floating-numbers-to-string-without-unnecessary-decimal-0
// this code is devolopment from http://agusharyanto.net
//

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public String str = "";
    Character op = 'q';
    float i, num, numtemp;
    EditText showResult;

    private static String formatDesimal(float f) {
        if (f == (long) f) return String.format("%d", (long) f);
        else return String.format("%s", f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showResult = (EditText) findViewById(R.id.result_id);
    }

    private void insert(int j) {
        str = str + Integer.toString(j);
        num = Integer.valueOf(str).intValue();
        showResult.setText(str);
    }

    private void reset() {
        str = "";
        op = 'q';
        num = 0;
        numtemp = 0;
        showResult.setText("");
    }

    private void perform() {
        //CharSequence chars = showResult.getText();
        //num = Integer.parseInt(chars.toString());
        //Toast.makeText(MainActivity.this, "num"+num, Toast.LENGTH_SHORT).show();
        calc();
        str = "";
        numtemp = num;
    }

    private void calc() {
        if (op == '+') num = numtemp + num;
        else if (op == '-') num = numtemp - num;
        else if (op == '/') num = numtemp / num;
        else if (op == '*') num = numtemp * num;
    }

    public void btn0Clicked(View v) {
        insert(0);
    }

    public void btn1Clicked(View v) {
        insert(1);
    }

    public void btn2Clicked(View v) {
        insert(2);
    }

    public void btn3Clicked(View v) {
        insert(3);
    }

    public void btn4Clicked(View v) {
        insert(4);
    }

    public void btn5Clicked(View v) {
        insert(5);
    }

    public void btn6Clicked(View v) {
        insert(6);
    }

    public void btn7Clicked(View v) {
        insert(7);
    }

    public void btn8Clicked(View v) {
        insert(8);
    }

    public void btn9Clicked(View v) {
        insert(9);
    }

    public void btnPlusClicked(View v) {
        perform();
        op = '+';
    }

    public void btnMinClicked(View v) {
        perform();
        op = '-';
    }

    public void btnBagiClicked(View v) {
        perform();
        op = '/';
    }

    public void btnKaliClicked(View v) {
        perform();
        op = '*';
    }

    public void btnHasilClicked(View v) {
        calc();
        showResult.setText("" + formatDesimal(num));
        //Toast.makeText(MainActivity.this, "numtemp=" + numtemp + "|num=" + num, Toast.LENGTH_SHORT).show();
        op = 'q';
        numtemp = 0;
        //num =0;
    }

    public void btnClearClicked(View v) {
        reset();
    }

}
