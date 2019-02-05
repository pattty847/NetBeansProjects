/* This software draws a version of the Mandelbrot set in a jFrame
 * using equations from fractal geometry.
 * 
 * Many similar versions of this program from various authors are available
 * on the Web.
 * 
 * last edited Jn 19, 2014 by C. Herbert
 */
package mandelbrot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
 
public class Mandelbrot extends JFrame {
 
    private final int MAX_ITER = 570;
    private static double ZOOM = 200;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
 
    public Mandelbrot() {
        super("Mandelbrot Set");
        setBounds(50, 50, 640, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        
        for (int y = 0; y < getHeight(); y++) {
        
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - 420) / ZOOM;
                cY = (y - 340) / ZOOM;
                int iter = MAX_ITER;
            
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                } // end while
               
                I.setRGB(x, y, iter | (iter << 13));
            }// end for x
        }  // end for y
        
    } // end  Mandelbrot()
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    } // end paint()
 
    public static void main(String[] args) {
        new Mandelbrot().setVisible(true);
    } // end manin()

} // end class Mandelbrot
