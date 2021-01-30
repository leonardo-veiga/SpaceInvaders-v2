package br.com.poo.spaceinvaders.gameobjects;

import br.com.poo.spaceinvaders.base.BasicElement;
import br.com.poo.spaceinvaders.base.Game;
import br.com.poo.spaceinvaders.base.KeyboardCtrl;
import br.com.poo.spaceinvaders.base.Params;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * Represents the game Gun
 * @author Bernardo Copstein, Rafael Copstein
 */
public class Canhao extends BasicElement implements KeyboardCtrl{
    public Canhao(int px,int py){
        super(px,py);
    }    
    
    @Override
    public void start() {
        setLimH(20,Params.WINDOW_WIDTH-20);
        setLimV(Params.WINDOW_HEIGHT-100,Params.WINDOW_HEIGHT);
        setLargAlt(32,32);
    }
    
    @Override
    public void Update() {
        if (jaColidiu()){
            deactivate();
            
        }
        setPosX(getX() + getDirH() * getSpeed());        
    }
    
    @Override
    public void OnInput(KeyCode keyCode, boolean isPressed) {
        if (keyCode == KeyCode.LEFT){
            int dh = isPressed ? -1 : 0;
            setDirH(dh);
        }
        if (keyCode == KeyCode.RIGHT){
            int dh = isPressed ? 1 : 0;
            setDirH(dh);
        }
        if (keyCode == KeyCode.SPACE){
            Game.getInstance().addChar(new Shot(getX()+16,getY()-17));
        }
        //if (keyCode == KeyCode.UP) do nothing
        //if (keyCode == KeyCode.DOWN) do nothing
    }
    
    @Override
    public void Draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#FF0000"));
        graphicsContext.fillRect(getX()+8, getY(), 16, 16);
        graphicsContext.fillRect(getX(), getY()+16, 32, 16);        
    }   
}
