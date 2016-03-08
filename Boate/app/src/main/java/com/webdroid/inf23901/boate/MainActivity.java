package com.webdroid.inf23901.boate;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

    GLSurfaceView vrSuperficieVisualizacao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Instancia a supercicie de Visualização
        vrSuperficieVisualizacao = new GLSurfaceView(this);

        //Objeto utilizado para controle do desenho
        Renderizador render = new Renderizador();

        //Configura o objeto de desenho para a superficie
        vrSuperficieVisualizacao.setRenderer(render);

        //Publica a superficie dna tela do aparelho
        setContentView(vrSuperficieVisualizacao);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_close) {
            //return true;
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

class Renderizador implements GLSurfaceView.Renderer{

    @Override // Chamado Toda a vez que for criado
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override // Chamado Toda a vez que rotacionar o aparelho
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //Log server para debugar
        //Log.d("teste", "Tela girada" + width + " " + height);
    }

    @Override //Chamado quantas vezes necessário para desenhar na tela
    public void onDrawFrame(GL10 vrOpengl) {
        //MEtodo utilizado para configurar a cor para  alimpeza da tela
        vrOpengl.glClearColor((float)Math.random(),(float)Math.random(),(float)Math.random(),1);

        //Limap a tela (Color_buffer_bit = Matriz de pixels da imagem)
        vrOpengl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        paussa(100);
    }

    private void paussa (int tempo){
        try{
         Thread.sleep(tempo);
        }catch (Exception e){}
    }
}