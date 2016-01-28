package id.chris64bit.calculatorandroid;
// formatdesimal() http://stackoverflow.com/questions/703396/how-to-nicely-format-floating-numbers-to-string-without-unnecessary-decimal-0
// this code is devolopment from http://agusharyanto.net
// memperbaiki view horisontal dgn scroll bar, membatasi input dengan 10 digit, menambahkan kapasitas jumlah perhitungan

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public String str = "";
    Character op = 'q';
    // variabel i untuk limit input agar tidak melebihi batas integer
    // num dan numtemp variable hasil
    double i, num, numtemp;
    EditText showResult;

    private static String formatDesimal(double f) {
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
        // limitasi untuk max integer
        if (i <= 999999999) {
            str = str + Long.toString(j);
            num = Long.valueOf(str).longValue();
            i = num;
            showResult.setText(str);
            //Log.d("TAG:","i="+i+"| num="+num);
        }
    }

    private void reset() {
        str = "";
        op = 'q';
        num = 0;
        numtemp = 0;
        i = 0;
        showResult.setText("");
    }

    private void perform() {
        //CharSequence chars = showResult.getText();
        //num = Integer.parseInt(chars.toString());
        i = 0;
        calc();
        str = "";
        numtemp = num;
        num =0; // to avoid if plus btn press more than one time
    }

    private void calc() {
        if (op == '+') num = numtemp + num;
        else if (op == '-') num = numtemp - num;
        else if (op == '/') num = numtemp / num;
        else if (op == '*') num = numtemp * num;
    }

    public void btn0Clicked(View v) {
        if (num !=0)
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
        op = 'q';
        numtemp = 0;
        //Log.d("TAG:","i="+i+"| num="+ num + "| numtemp=" + numtemp);
    }

    public void btnClearClicked(View v) {
        reset();
    }
}
