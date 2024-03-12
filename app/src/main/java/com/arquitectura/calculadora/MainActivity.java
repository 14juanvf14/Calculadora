package com.arquitectura.calculadora;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    TextView txtPantalla;
    double num1 = 0, num2 = 0;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPantalla = findViewById(R.id.txtViewResult);
    }

    public void onClickNum1(View view) {
        appendNumber("1");
    }

    public void onClickNum2(View view) {
        appendNumber("2");
    }

    public void onClickNum3(View view) {
        appendNumber("3");
    }

    public void onClickNum4(View view) {
        appendNumber("4");
    }

    public void onClickNum5(View view) {
        appendNumber("5");
    }

    public void onClickNum6(View view) {
        appendNumber("6");
    }

    public void onClickNum7(View view) {
        appendNumber("7");
    }

    public void onClickNum8(View view) {
        appendNumber("8");
    }

    public void onClickNum9(View view) {
        appendNumber("9");
    }

    public void onClickNum0(View view) {
        appendNumber("0");
    }

    public void onClickPunto(View view) {
        appendNumber(".");
    }

    public void onClickNumDelete(View view) {
        String numActual = txtPantalla.getText().toString();

        if (!numActual.equals("0")) {
            if (numActual.length() > 1) {
                String nuevoNumero = numActual.substring(0, numActual.length() - 1);
                txtPantalla.setText(nuevoNumero);
            } else {
                txtPantalla.setText("0");
            }
        }
    }

    public void onClickNumClear(View view) {
        txtPantalla.setText("0");
        num1 = 0;
        num2 = 0;
        operacion = "";
    }

    public void onClickSuma(View view) {
        performOperation();
        operacion = "+";
        txtPantalla.setText("0");
    }

    public void onClickResta(View view) {
        performOperation();
        operacion = "-";
        txtPantalla.setText("0");
    }

    public void onClickMultiplicacion(View view) {
        performOperation();
        operacion = "*";
        txtPantalla.setText("0");
    }

    public void onClickDivision(View view) {
        performOperation();
        operacion = "/";
        txtPantalla.setText("0");
    }

    public void onClickIgual(View view) {
        performOperation();
        if ("raiz".equals(operacion)) {
            if (num1 >= 0) {
                txtPantalla.setText(String.format("%.2f", Math.sqrt(num1)));
            } else {
                Toast.makeText(this, "No se puede calcular la raíz cuadrada de un número negativo", Toast.LENGTH_LONG).show();
            }
        }

        operacion = "";
    }

    public void onClickRaizCuadrada(View view) {
        performOperation();
        operacion = "raiz";
        num1 = Double.parseDouble(txtPantalla.getText().toString());
        txtPantalla.setText("√" + num1);
    }


    private void appendNumber(String number) {
        String numActual = txtPantalla.getText().toString();
        // Verificar si el número actual ya contiene un punto decimal
        if (!numActual.contains(".") || !number.equals(".")) {
            if (numActual.equals("0")) {
                txtPantalla.setText(number);
            } else {
                txtPantalla.setText(numActual + number);
            }
        }
    }

    private void performOperation() {
        String numActual = txtPantalla.getText().toString();
        double currentNumber=0;
        if (!numActual.isEmpty()) {
            if (!operacion.equals("raiz")){
                currentNumber = Double.parseDouble(numActual);
            }


            if (!operacion.isEmpty()) {
                // Si hay una operación pendiente, realizamos la operación
                switch (operacion) {
                    case "+":
                        num1 += currentNumber;
                        break;
                    case "-":
                        num1 -= currentNumber;
                        break;
                    case "*":
                        num1 *= currentNumber;
                        break;
                    case "/":
                        if (currentNumber != 0) {
                            num1 /= currentNumber;
                        } else {
                            Toast.makeText(this, "Se ha ejecutado una división por 0", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case "raiz":
                        // Calcula la raíz cuadrada y muestra el resultado

                        break;
                }
                txtPantalla.setText(String.format("%.2f", num1));
            } else {
                // Si no hay operación actual, simplemente asignamos el valor actual a num1
                num1 = currentNumber;
            }
        }
    }
}
