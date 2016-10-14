package id.sch.smktelkom_mlg.tugas01.xiirpl1032.formpendafatanles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etAlamat, etHP;
    RadioButton rbPria, rbWanita;
    Button bDaftar;
    TextView tvHasil, tvHasil2, tvHasil3;
    Spinner spKelas;
    CheckBox cbSenin, cbSelasa, cbRabu, cbKamis, cbJumat, cbSabtu, cbMinggu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextnama);
        etAlamat = (EditText) findViewById(R.id.editTextalamat);
        etHP = (EditText) findViewById(R.id.editTexthp);
        bDaftar = (Button) findViewById(R.id.buttondaftar);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        rbPria = (RadioButton) findViewById(R.id.pria);
        rbWanita = (RadioButton) findViewById(R.id.wanita);
        spKelas = (Spinner) findViewById(R.id.spinnerkelas);
        cbSenin = (CheckBox) findViewById(R.id.checkBox);
        cbSelasa = (CheckBox) findViewById(R.id.checkBox2);
        cbRabu = (CheckBox) findViewById(R.id.checkBox3);
        cbKamis = (CheckBox) findViewById(R.id.checkBox4);
        cbJumat = (CheckBox) findViewById(R.id.checkBox5);
        cbSabtu = (CheckBox) findViewById(R.id.checkBox6);
        cbMinggu = (CheckBox) findViewById(R.id.checkBox7);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hasil = null;
                if (rbPria.isChecked()) {
                    hasil = rbPria.getText().toString();
                } else if (rbWanita.isChecked()) {
                    hasil = rbWanita.getText().toString();
                }


                if (isValid()) {
                    String nama = etNama.getText().toString();
                    String alamat = etAlamat.getText().toString();
                    String hp = etHP.getText().toString();
                    tvHasil.setText("Nama" + "\t\t\t\t\t: " + nama + "\n" + "Jenis Kelamin" + "\t: " + hasil + "\n" + "Alamat" + "\t\t\t\t: " + alamat + "\n" + "Kelas" + "\t\t\t\t\t: " + spKelas.getSelectedItem().toString() + "\n" + "Nomor HP" + "\t\t\t: " + hp);
                }
                doClick();
            }
        });
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String hp = etHP.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat belum diisi");
            valid = false;
        } else if (alamat.length() < 4) {
            etAlamat.setError("Alamat minimal 4 karakter");
        } else {
            etAlamat.setError(null);
        }

        if (hp.isEmpty()) {
            etHP.setError("Nomor HP belum diisi");
        } else {
            etHP.setError(null);
        }

        return valid;
    }

    private void doClick() {
        String hasilcb = "Jadwal Les\t\t: ";
        int jum = 0;
        int startlen = hasilcb.length();
        if (cbSenin.isChecked()) {
            jum += 1;
            hasilcb += cbSenin.getText() + ", ";
        }
        if (cbSelasa.isChecked()) {
            jum += 1;
            hasilcb += cbSelasa.getText() + ", ";
        }
        if (cbRabu.isChecked()) {
            jum += 1;
            hasilcb += cbRabu.getText() + ", ";
        }
        if (cbKamis.isChecked()) {
            jum += 1;
            hasilcb += cbKamis.getText() + ", ";
        }
        if (cbJumat.isChecked()) {
            jum += 1;
            hasilcb += cbJumat.getText() + ", ";
        }
        if (cbSabtu.isChecked()) {
            jum += 1;
            hasilcb += cbSabtu.getText() + ", ";
        }
        if (cbMinggu.isChecked()) {
            jum += 1;
            hasilcb += cbMinggu.getText() + ", ";
        }

        if (hasilcb.length() == startlen) hasilcb += "Tidak memilih jadwal";
        tvHasil2.setText(hasilcb);
        tvHasil3.setText("Pembayaran\t\t : " + jum + " x " + "30.000" + " x 4 " + " = Rp." + jum * 30000 * 4 + "/bulan");

    }
}
