package id.mhamhank.biodata

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ambilData()
        EditName.setOnClickListener { navigasiKeEditProfil() }

        Call.setOnClickListener {
            dialPhoneNumber(TelponU.text.toString())
        }

    }

    private fun ambilData() {
        val bundle = intent.extras

        val Name = bundle?.getString("Name")
        val Gender = bundle?.getString("Gender")
        val Email = bundle?.getString("Email")
        val Telpon = bundle?.getString("Telpon")
        val Alamat = bundle?.getString("Alamat")

        NameU.text = Name
        GenderU.text = Gender
        TelponU.text = Telpon
        EmailU.text = Email
        AlamatU.text = Alamat
    }

    companion object {
        val REQUEST_CODE = 100
    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfilActivity::class.java)
        val Name = NameU.text.toString()
        intent.putExtra("nama", Name)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                NameU.text = result
            } else {
                Toast.makeText(this, "Edit failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private fun navigasiKeAbout(){
        val intent = Intent (this, AboutActivity ::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }
}


