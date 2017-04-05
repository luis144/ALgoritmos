package com.example.upam.algoritmos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import static android.R.attr.x;
import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.panel);

    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            int x = 0, y = 0, x0, y0, x1, y1, pk, r;
            float m, b;

            x0 = 50;
            x1 = 290;
            y0 = 50;
            y1 = 120;
            // Algoritmo linea recta
            // Calcular la pendiente y la constante b
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            m = (float) (y1 - y0) / (x1 - x0);
            b = (float) (y0 - m * x0);
            x = x0;
            y = y0;
            // Tomar el intervalo del eje X y determinar Y
            while (x < x1 + 1) {
                //Dibujar un pixel en la posición X, Y
                canvas.drawPoint(x, Math.round(y), paint);
                x++;
                y = (int) (m * x + b); /* Ecuación punto pendiente de la recta */
            }

        }
    }


    public void crear(View v) {

        Lienzo fondo = new Lienzo(this);
        relativeLayout.addView(fondo);
    }

    public void crear2(View v) {
        casita fondo = new casita(this);
        relativeLayout.addView(fondo);
    }

    class casita extends View {

        public casita(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            super.onDraw(canvas);
            Log.d("whit", "w=+" + getWidth()); //tamañao de la pantalla
            Log.d("heigth", "h=+" + getHeight());//Tamaño de la pantalla
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(10);
            paint.setColor(Color.BLACK);
            canvas.drawLine(650, 600, 376, 500, paint); // techo
            canvas.drawLine(100, 600, 378, 500, paint); // techo
            canvas.drawLine(100, 600, 650, 600, paint); // techo


            // Puerta posicion y area
            paint.setColor(Color.YELLOW);
            canvas.drawRect(new Rect(350, 620, 400, 730), paint);
            paint.setColor(Color.BLACK);
            // piso
            canvas.drawLine(130, 750, 620, 750, paint);
            // pared izquierda
            canvas.drawLine(130, 605, 130, 755, paint);
            canvas.drawLine(620, 605, 620, 755, paint);
            canvas.drawLine(130, 605, 130, 755, paint);


            // ventanas
            Paint ven = new Paint();

            ven.setStyle(Paint.Style.FILL_AND_STROKE);
            ven.setStrokeWidth(15);
            ven.setColor(Color.BLUE);
                                     //xI  yI   XF   YF
            canvas.drawRect(new Rect(250, 630, 300, 670), ven);// ventana
            canvas.drawRect(new Rect(450, 630, 500, 670), ven);//panel inferior izquierda
        }

    }

    class lineaDDA extends View {
        public lineaDDA(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            int x0, x1, y0, y1;
            Paint paint = new Paint();
            super.onDraw(canvas);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            x0 = 50;
            x1 = 290;
            y0 = 70;
            y1 = 180;
            float m, y3;
            // Calcular la pendiente
            m = (float) (y1 - y0) / (x1 - x0);
            int x = x0;
            y3 = y0;
            // Tomar el intervalo del eje X y determinar Y
            while (x < x1 + 1) {
                //Dibujar un punto en la coordenada X, Y
                canvas.drawPoint(Math.round(x), Math.round(y3), paint);
            /* Determinar el siguiente pixel */
                x++;
                y3 += m; // el incremento es la pendiente

            }
        }
    }

    public void crear3(View v) {
        lineaDDA fondo = new lineaDDA(this);
        relativeLayout.addView(fondo);
    }

    class colorDeLinea extends View {
        public colorDeLinea(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            int x, y, x0, y0, x1, y1, pk;
            Paint paint = new Paint();
            super.onDraw(canvas);

            // Identificar los valores x0,y0
            x0 = 50;
            x1 = 290;
            y0 = 90;
            y1 = 160;
            x = x0;
            y = y0;
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            // Calcular la constantes deltax, deltay, 2.deltay y 2deltay-2deltax
            int deltax = x1 - x0;
            int deltay = y1 - y0;
            int incrA = 2 * deltay; // incremento si Pk es menor a 0
            int incrB = 2 * (deltay - deltax);
            pk = 2 * deltay - deltax; // calcular p0
            // Tomar el intervalo del eje X y determinar Y
            while (x < x1 + 1) {
                canvas.drawPoint(x, Math.round(x), paint);
                //  pintarPixel(x, (int) y);
            /* Deteminar el siguiente pixel */
                x++;
                if (pk < 0) {
                    pk += incrA;
                } else {
                    y++;
                    pk += incrB;
                }

            }
        }
    }

    public void crear4(View v) {
        colorDeLinea fondo = new colorDeLinea(this);
        relativeLayout.addView(fondo);
    }


    class CirculoBreshman extends View {
        public CirculoBreshman(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            int x, y, x0, y0, x1, y1, pk, r;
            Paint paint = new Paint();
            super.onDraw(canvas);

            // Identificar los valores x0,y0
            r = 150;
            x0 = 375;
            y0 = 375;
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            double theta = Math.toRadians(0);
            // Punto inicial
            x = r;
            y = 0;
            // Mientras el angulo no exceda a 360 dibujar puntos
            while (theta <= 2 * Math.PI) {
                canvas.drawPoint(x + x0, y + y0, paint);
                // Incrementar el ángulo
                theta = theta + Math.toRadians(5);
                // Cálcular los valores x e y de forma parámetrica
                double xd = r * Math.cos(theta);
                x = (int) Math.round(xd);
                double yd = r * Math.sin(theta);
                y = (int) yd;

            }
        }
    }

    public void crear5(View v) {
        CirculoBreshman fondo = new CirculoBreshman(this);
        relativeLayout.addView(fondo);
    }

    class CirculoPunto extends View {
        public CirculoPunto(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            int x, y, x0, y0, x1, y1, pk, r;
            Paint paint = new Paint();
            super.onDraw(canvas);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(2);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            //circulo por medio de puntomedio algoritmo de breshman
            // Punto inicial del círculo
            r=100;
            x0=375;
            y0=375;
            x = 0;
            y = r;
            // Cálcular el parámetro inicial de decisión
            pk = 1-r;
            // verificar el pk para determinar las posiciones de pixel siguuientes
            while (x<y) {
                System.out.println("(x,y)= " + x + "," + y + " pk=" + pk);

                if (pk < 0) {
                    pk += 2 * (x + 1) + 1;
                    x++;
                    canvas.drawPoint(x0 + x, y0 + y, paint);
                    canvas.drawPoint(x0 - x, y0 + y, paint);
                    canvas.drawPoint(x0 + x, y0 - y, paint);
                    canvas.drawPoint(x0 - x, y0 - y, paint);
                } else // pk>=0
                {
                    pk += 2 * (x + 1) + 1 - 2 * (y - 1);
                    x++;
                    y--;
                    canvas.drawPoint(x0 + y, y0 + x, paint);
                    canvas.drawPoint(x0 - y, y0 + x, paint);
                    canvas.drawPoint(x0 + y, y0 - x, paint);
                    canvas.drawPoint(x0 - y, y0 - x, paint);
                }

            }
        }

        }

    public void crear6(View v) {
        CirculoPunto fondo = new CirculoPunto(this);
        relativeLayout.addView(fondo);
    }

    class elipse extends View {

        public elipse(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {

            Paint paint = new Paint();
            super.onDraw(canvas);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(2);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            int x=0, y=10, x2=0, rx2=100, ry2=100,px=10,py=10,p;
            int xc=100, yc=100, rx=0, ry=0, A=0,B=0;
            // dibujar el centro del circulo

            y=ry;

            rx2=rx*rx;
            ry2=ry*ry;
            //constantes
            A=2*rx2;
            B=2*ry2;

            canvas.drawPoint(x,y,paint);
            p = (int)Math.round(ry2 -(rx2*ry) + (0.25*rx2));
            while(px<py)
            {    x++;
                px=px+B;
                if(p<0)
                {
                    p=p+ry2+px;
                }
                else
                {
                    y--;
                    py=py-A;
                    p=p+ry2+px-py;
                }
                canvas.drawPoint(xc+x, yc+y,paint);
                canvas.drawPoint(xc-x,yc+y,paint);
                canvas.drawPoint(xc+x,yc-y,paint);
                canvas.drawPoint(xc-x,yc-y,paint);
            }
            p= (int)((ry2)*Math.pow((x+0.5),2)+(rx2)*Math.pow((y-1),2)-(rx2*ry2));
            while(y>0)
            {   y--;
                py=py-A;
                if (p>0)
                {
                    y--;
                    p=p+rx2-py;
                }
                else
                {
                    x++;
                    px=px+B;
                    p=p+px+ry2-py;
                }
                canvas.drawPoint(xc+x, yc+y,paint);
                canvas.drawPoint(xc-x,yc+y,paint);
                canvas.drawPoint(xc+x,yc-y,paint);
                canvas.drawPoint(xc-x,yc-y,paint);
            }

        }
        }



    public void crear7(View v) {
        elipse fondo = new elipse(this);
        relativeLayout.addView(fondo);

    }






}


