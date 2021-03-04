package vortex.project.appproductslist

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import vortex.project.appproductslist.data.product


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in product.indices){
            val txt = TextView(this)
                txt.text = product[i].name
                txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F)
                txt.setTypeface(Typeface.DEFAULT, 1)
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(10, 10, 10, 10)
                txt.setLayoutParams(params)

            txt.setOnClickListener {

                Toast.makeText(applicationContext , "Done!", 10).show()

                val productIntent = Intent(this, ProductActivity::class.java)

                productIntent.putExtra("PRODUCT_INDEX", i.toString())

                startActivity(productIntent)
            }
            linearLayoutCard.addView(txt)
        }
    }
}