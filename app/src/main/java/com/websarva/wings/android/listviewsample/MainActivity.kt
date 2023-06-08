package com.websarva.wings.android.listviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Listオブジェクトを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        //ListViewにリスナ設定
        lvMenu.onItemClickListener = ListItemClickListner()
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた定食名を取得 getItemAtPositionの戻り値はanyなのでStringにキャスト
            val item = parent.getItemAtPosition(position) as String
            // トーストで表示する文字列を生成
            val show = "あなたが選んだ定食:" + item
            // トーストの表示
            // 第１引数：トーストを表示させるアクティビティ(contextと呼ぶ)
            // 第２引数：表示文字列
            // 第３引数：トーストが表示される長さ
            Toast.makeText(this@MainActivity, show, Toast.LENGTH_LONG).show()
        }
    }
}