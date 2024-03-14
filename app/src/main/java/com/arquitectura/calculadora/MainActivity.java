package com.arquitectura.calculadora;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


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
        if (operacion.equals("raiz")) {
            if (num1 >= 0) {
                txtPantalla.setText(formatoDecimal(Math.sqrt(num1)));
            } else {
                Toast.makeText(this, "No se puede calcular la raíz cuadrada de un número negativo", Toast.LENGTH_LONG).show();
            }
        } else if (operacion.equals("cuadrado")) {
            txtPantalla.setText(formatoDecimal(Math.pow(num1, 2)));
        } else if (operacion.equals("seno")) {
            try {
                txtPantalla.setText(formatoDecimal(Math.sin(Math.toRadians(num1))));
            } catch (Exception e) {
                Toast.makeText(this, "Error al calcular el seno", Toast.LENGTH_LONG).show();
            }
        } else if (operacion.equals("coseno")) {
            try {
                txtPantalla.setText(formatoDecimal(Math.cos(Math.toRadians(num1))));
            } catch (Exception e) {
                Toast.makeText(this, "Error al calcular el coseno", Toast.LENGTH_LONG).show();
            }
        } else if (operacion.equals("tangente")) {
            try {
                txtPantalla.setText(formatoDecimal(Math.tan(Math.toRadians(num1))));
            } catch (Exception e) {
                Toast.makeText(this, "Error al calcular la tangente", Toast.LENGTH_LONG).show();
            }
        } else if (operacion.equals("lg10")) {
            try {
                txtPantalla.setText(formatoDecimal(Math.log10(num1)));
            } catch (Exception e) {
                Toast.makeText(this, "Error al calcular el logaritmo base 10", Toast.LENGTH_LONG).show();
            }
        } else {
            performOperation();
        }
        operacion = "";
    }

    public String formatoDecimal(double numero) {
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setMaximumFractionDigits(5);
        df.setMinimumFractionDigits(0);
        return df.format(numero);
    }


    public void onClickRaizCuadrada(View view) {
        operacion = "raiz";
        try {
            num1 = Double.parseDouble(txtPantalla.getText().toString());
            txtPantalla.setText("√(" + num1 + ")");
        } catch (NumberFormatException e) {
            // Manejar el caso en el que el texto no se pueda analizar como un número flotante
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickCuadrado(View view) {
        operacion = "cuadrado";
        try {
            num1 = Double.parseDouble(txtPantalla.getText().toString());
            txtPantalla.setText(num1 + "²");
        } catch (NumberFormatException e) {
            // Manejar el caso en el que el texto no se pueda analizar como un número flotante
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSeno(View view) {
        operacion = "seno";
        try {
            num1 = Double.parseDouble(txtPantalla.getText().toString());
            txtPantalla.setText("sin(" + num1 + ")");
        } catch (NumberFormatException e) {
            // Manejar el caso en el que el texto no se pueda analizar como un número flotante
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickCoseno(View view) {
        operacion = "coseno";
        try {
            num1 = Double.parseDouble(txtPantalla.getText().toString());
            txtPantalla.setText("cos(" + num1 + ")");
        } catch (NumberFormatException e) {
            // Manejar el caso en el que el texto no se pueda analizar como un número flotante
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickTangente(View view) {
        operacion = "tangente";
        try {
            num1 = Double.parseDouble(txtPantalla.getText().toString());
            txtPantalla.setText("tan(" + num1 + ")");
        } catch (NumberFormatException e) {
            // Manejar el caso en el que el texto no se pueda analizar como un número flotante
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickLg10(View view) {
        operacion = "lg10";
        try {
            num1 = Double.parseDouble(txtPantalla.getText().toString());
            txtPantalla.setText("lg(" + num1 + ")");
        } catch (NumberFormatException e) {
            // Manejar el caso en el que el texto no se pueda analizar como un número flotante
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }
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
                }
                txtPantalla.setText(formatoDecimal(num1));
            } else {
                // Si no hay operación actual, simplemente asignamos el valor actual a num1
                num1 = currentNumber;
            }
        }
    }
}
