package id.mhamhank.biodata

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Save.setOnClickListener { validasiInput() }
    }

    private fun goToProfilActivity() {
      val intent = Intent (this, ProfileActivity::class.java)

        val bundle = Bundle()
        bundle.putString("Nama", NameU)
        bundle.putString("Gender", GenderU)
        bundle.putString("Email", EmailU )
        bundle.putString("Telpon", TelponU)
        bundle.putString("Alamat", AlamatU)

        intent.putExtras (bundle)

        startActivity(intent)
    }
    //variable global
    private var NameU : String = ""
    private var EmailU : String = ""
    private  var TelponU : String = ""
    private  var AlamatU : String = ""
    private var GenderU : String = ""

    private  fun validasiInput(){
        NameU = TxtNama.text.toString()
        EmailU = TxtEmail.text.toString()
        TelponU = TxtTelp.text.toString()
        AlamatU = TxtAlamat.text.toString()
        GenderU = SpinGender.selectedItem.toString()

        when {
            NameU.isEmpty() -> TxtNama.error = "Nama Tidak Boleh Kosong"
            GenderU.equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin Harus Dipilih")
            EmailU.isEmpty() -> TxtEmail.error = "Email Tidak Boleh Kosong"
            TelponU.isEmpty() -> TxtEmail.error = "Telp Tidak Boleh Kosong"
            AlamatU.isEmpty() -> TxtAlamat.error = "Alamat Tidak Boleh Kosong"

            else -> {
                tampilToast("Navigasi Ke Halaman Profil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT ).show()


    }
}
