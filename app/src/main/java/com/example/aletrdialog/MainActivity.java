package com.example.aletrdialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Builder dialog, dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnAbrir = findViewById(R.id.btn_abrir);
        btnAbrir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog = new Builder(MainActivity.this);
                dialog.setTitle("Teste de AlertDialog");
                dialog.setMessage("Este e um exemplo para o curso IFSP");

                dialog.setIcon(android.R.drawable.ic_delete);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick (DialogInterface dialog, int which) {
                                //alguma coisa a ser definida//
                                Toast.makeText(MainActivity.this, "Clicou em OK",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //alguma coisa a ser definida//
                                Toast.makeText(MainActivity.this, "Clicou em Cancelar",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                dialog.setNeutralButton("Mais Informações", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Clicou em Mais Informações",
                                        Toast.LENGTH_LONG).show();

                    }
                });
                dialog.show();
            }
        });

        Button btnAbrir2 = findViewById(R.id.btn_abrir2);
        btnAbrir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nova vizualizacao do dialog
                dialog2 = new Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog, null);
                dialog2.setView(view);
                EditText edtNome = view.findViewById(R.id.username);
                EditText edtSenha = view.findViewById(R.id.password);
                Button btnOK = view.findViewById(R.id.btn_login);
                Button btnCancelar = findViewById(R.id.btn_cancel);

                AlertDialog alertDialog = dialog2.show();
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String strNome = edtNome.getText().toString();
                    String strSenha = edtSenha.getText().toString();
                    Toast.makeText(MainActivity.this, "Nome: " + strNome + " Senha: " + strSenha,
                            Toast.LENGTH_LONG).show();
                    alertDialog.dismiss();
                }
            });

            }
        });
    }
}