package example.otakbeku.iak_latihan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtJumlah, txtPrice, txtQuantity, txt_Cream, txtStranger, txtSankyu;
    Button btnOrder, btnDecrement, btnIncrement;
    CheckBox cbxCream, cbxCoklat;
    EditText txtName;


    int jumlah = 0;
    int TOTAL = 0;
    int jumlah_inc = 0;
    final int HARGA = 2500;
    final int INCREMENT = 1000;
    final int TOPPING_CREAM = 500;
    final int TOPPING_COKLAT = 1500;
    Boolean isCream = false, isCoklat = false;
    Boolean cekNama = false;
    String tempName = null;
    String nama = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJumlah = (TextView) findViewById(R.id.txtQuantity);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        //tambahan
        btnDecrement = (Button) findViewById(R.id.btnDecrement);
        btnIncrement = (Button) findViewById(R.id.btnIncrement);

        txt_Cream = (TextView) findViewById(R.id.txt_Cream);
        cbxCream = (CheckBox) findViewById(R.id.cbxCream);
        txtQuantity = (TextView) findViewById(R.id.txtQuantity2);

        txtName = (EditText) findViewById(R.id.txtName);
        txtStranger = (TextView) findViewById(R.id.txtStranger);

        txtSankyu = (TextView) findViewById(R.id.txtSankyu);
        //INVISIBLE = dimensinya masih ada
        //GONE = Dihilangkan kontennya


        txtStranger.setVisibility(txtStranger.GONE);
        txtSankyu.setVisibility(txtSankyu.GONE);

        cbxCoklat = (CheckBox) findViewById(R.id.cbxCoklat);

//        btnOrder.setOnClickListener(this);
//        btnDecrement.setOnClickListener(this);
//        btnIncrement.setOnClickListener(this);


//        btnOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // codenya disini
//            }
//        });
    }

    public void pesan(View view) {
        Log.i("Jumlah ", "" + jumlah);
        Log.i("TOTAL: ", Integer.toString(TOTAL));
//        nama = txtName.getText().toString();
        if (!(jumlah == 0)) {
            if (isCream) {
//            TOTAL = jumlah_inc;
                TOTAL = jumlah_inc + Centang(view);

            } else {
                TOTAL = jumlah_inc;
            }
        }
        if (jumlah == 0) {
            TOTAL = 0;
        }
        txtQuantity.setText("Quantity : " + Integer.toString(jumlah));


        txtPrice.setText("Price Rp : " + TOTAL);

        if (isCream) {
            txt_Cream.setText("Added Cream ? Yes");
        } else {
            txt_Cream.setText("Added Cream ? No");
        }

        if (isCream) {
            txt_Cream.setText("Added Cream ? Yes");
        } else {
            txt_Cream.setText("Added Cream ? No");
        }

        //tambahan coklat

        if (txtName.getText() != null && !cekNama) {
            cekNama = true;
//            tempName = txtName.getText().toString();
            txtStranger.setVisibility(txtStranger.VISIBLE);
            txtStranger.append(txtName.getText().toString() + "!");
            txtSankyu.setVisibility(txtSankyu.VISIBLE);
        }
        if (txtName.getText() != null) {
            cekNama = false;
            txtStranger.setVisibility(txtStranger.GONE);
            txtSankyu.setVisibility(txtSankyu.GONE);
        }
    }

    public void decrement(View view) {
        if (jumlah != 0)
            jumlah--;
        jumlah_inc = jumlah * HARGA;
        Log.i("DEC: ", Integer.toString(jumlah_inc));
        txtJumlah.setText(Integer.toString(jumlah));
    }

    public void increment(View view) {
        jumlah++;
        jumlah_inc = jumlah * HARGA;
        Log.i("INC: ", Integer.toString(jumlah_inc));
        txtJumlah.setText(Integer.toString(jumlah));
    }

    @Override
    public void onClick(View view) {
        if (view == btnOrder) {

        }
    }

//    public void Centang(View view) {
//        if (cbxCream.isChecked()) {
//            Toast.makeText(MainActivity.this, "Anda mencentang Topping", Toast.LENGTH_SHORT).show();
//            isCream = true;
//            if (jumlah == 1) {
//                TOTAL = TOTAL + TOPPING;
//            } else if (jumlah >= 2) {
//                TOTAL = TOTAL + (TOPPING * jumlah);
//            }
//            Log.i("TOTAL: ", Integer.toString(TOTAL));
//            Log.i("TOPPING: ", Integer.toString(TOPPING));
//        } else if (!cbxCream.isChecked()) {
//            Toast.makeText(MainActivity.this, "Anda men-un-centang Topping", Toast.LENGTH_SHORT).show();
//            isCream = false;
//            if (jumlah > 1) {
//                TOTAL = TOTAL - (TOPPING * jumlah);
//            }
//        }
//    }

    /**
     * Method untuk Menambahkan harga saat user memilih Cream
     *
     * @param view
     * @return berupa nilai dari TOPPING di kali dengan jumlah order yang dipesan
     */
    public int Centang(View view) {
        int cream = 0;
        int coklat = 0;
        if (cbxCream.isChecked()) {
            Toast.makeText(MainActivity.this, "Anda mencentang Topping cream", Toast.LENGTH_SHORT).show();
            isCream = true;
            if (jumlah == 1) {
//                TOTAL = TOTAL + TOPPING;
                cream = TOPPING_CREAM;
            } else if (jumlah >= 2) {
//                TOTAL = TOTAL + (TOPPING * jumlah);
                cream = TOPPING_CREAM * jumlah;
            }
            Log.i("TOTAL: ", Integer.toString(TOTAL));
            Log.i("TOPPING: ", Integer.toString(TOPPING_CREAM));
        } else if (!cbxCream.isChecked()) {
            Toast.makeText(MainActivity.this, "Anda men-un-centang Topping cream", Toast.LENGTH_SHORT).show();
            isCream = false;
            if (jumlah > 1) {
//                TOTAL = TOTAL - (TOPPING * jumlah);
                cream = TOPPING_CREAM * (jumlah - 1);
                cream = -cream;
            }

            //tambahan
            // BAGIAN COKLAT
            if (cbxCoklat.isChecked()) {
                Toast.makeText(MainActivity.this, "Anda mencentang Topping coklat", Toast.LENGTH_SHORT).show();
                isCoklat = true;
                if (jumlah == 1) {
//                TOTAL = TOTAL + TOPPING;
                    coklat = TOPPING_COKLAT;
                } else if (jumlah >= 2) {
//                TOTAL = TOTAL + (TOPPING * jumlah);
                    coklat = TOPPING_CREAM * jumlah;
                }
                Log.i("TOTAL: ", Integer.toString(TOTAL));
                Log.i("TOPPING: ", Integer.toString(TOPPING_CREAM));
            } else if (!cbxCoklat.isChecked()) {
                Toast.makeText(MainActivity.this, "Anda men-un-centang Topping coklat", Toast.LENGTH_SHORT).show();
                isCoklat = false;
                if (jumlah > 1) {
//                TOTAL = TOTAL - (TOPPING * jumlah);
                    coklat = TOPPING_COKLAT * (jumlah - 1);
                    coklat = -coklat;
                }
            }
        }
        return cream + coklat;
    }
}

//    public int Centang_coklat(View view) {
//        int cream = 0;
//        if (cbxCream.isChecked()) {
//            Toast.makeText(MainActivity.this, "Anda mencentang Topping", Toast.LENGTH_SHORT).show();
//            isCream = true;
//            if (jumlah == 1) {
////                TOTAL = TOTAL + TOPPING;
//                cream = TOPPING_CREAM;
//            } else if (jumlah >= 2) {
////                TOTAL = TOTAL + (TOPPING * jumlah);
//                cream = TOPPING_CREAM * jumlah;
//            }
//            Log.i("TOTAL: ", Integer.toString(TOTAL));
//            Log.i("TOPPING: ", Integer.toString(TOPPING_CREAM));
//        } else if (!cbxCream.isChecked()) {
//            Toast.makeText(MainActivity.this, "Anda men-un-centang Topping", Toast.LENGTH_SHORT).show();
//            isCream = false;
//            if (jumlah > 1) {
////                TOTAL = TOTAL - (TOPPING * jumlah);
//                cream = TOPPING_CREAM * (jumlah - 1);
//                cream = -cream;
//            }
//        }
//        return cream;
//    }
//
//    public int Centang_cream(View view) {
//        int cream = 0;
//        if (cbxCream.isChecked()) {
//            Toast.makeText(MainActivity.this, "Anda mencentang Topping", Toast.LENGTH_SHORT).show();
//            isCream = true;
//            if (jumlah == 1) {
////                TOTAL = TOTAL + TOPPING;
//                cream = TOPPING_CREAM;
//            } else if (jumlah >= 2) {
////                TOTAL = TOTAL + (TOPPING * jumlah);
//                cream = TOPPING_CREAM * jumlah;
//            }
//            Log.i("TOTAL: ", Integer.toString(TOTAL));
//            Log.i("TOPPING: ", Integer.toString(TOPPING_CREAM));
//        } else if (!cbxCream.isChecked()) {
//            Toast.makeText(MainActivity.this, "Anda men-un-centang Topping", Toast.LENGTH_SHORT).show();
//            isCream = false;
//            if (jumlah > 1) {
////                TOTAL = TOTAL - (TOPPING * jumlah);
//                cream = TOPPING_CREAM * (jumlah - 1);
//                cream = -cream;
//            }
//        }
//        return cream;
//    }

//    public Boolean cekNama() {
//
//    }

