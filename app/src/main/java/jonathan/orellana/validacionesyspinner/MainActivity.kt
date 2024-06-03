package jonathan.orellana.validacionesyspinner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //mandar a llamar a los elementos
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //agregar evento al boton
        btnAgregar.setOnClickListener{
            //validar que campos no esten vacios
            if(txtNombre.text.isEmpty() || txtContrasena.text.isEmpty() || txtCorreo.text.isEmpty() || txtEdad.text.isEmpty() || txtDUI.text.isEmpty()){
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            } else if (txtEdad.text.matches("[0-9]+".toRegex())){
                Toast.makeText(this, "Campos agregados", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this, "Por favor ingrese datos válidos", Toast.LENGTH_SHORT).show()
            }

            //validar correo
            if (txtCorreo.text.matches("[a-zA-Z0-9._*]+@[a-z]+\\\\.+[a-z]+]".toRegex())){
                Toast.makeText(this, "Correo válido", Toast.LENGTH_SHORT).show()
            }

            else{
                Toast.makeText(this, "Correo inválido", Toast.LENGTH_SHORT).show()
            }

            //validar contra
            if(txtContrasena.text.length < 6){
                Toast.makeText(this, "La contraseña debe tenr más de 6 dígitos", Toast.LENGTH_SHORT).show()
            }

            //TAREA validad DUI
            if(txtDUI.text.matches("[0-9]+-[0-9]+".toRegex())&& txtDUI.text <= 10){

            }else{

            }
        }
    }
}