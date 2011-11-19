///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package game.entity;
//
//import java.awt.Rectangle;
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// *
// * @author Lucas
// */
//public class Stage{
//
//    /*implementar método toString!*/
//    private String name_ = null;
//    private Entity borderEntity = null;
//    private int width_ = 0;
//    private int height_ = 0;
//    private int x_ = 0;
//    private int y_ = 0;
//    /*instanciar e criar métodos de adição e remoção*/
//    private ArrayList<Entity> entidades_ = null;
//
//    public Stage(String name, Rectangle box){
//        
//    }
//
//    public Stage(String name, int width, int height){
//        this.entidades_ = new ArrayList<Entity>();
//        this.name_ = name;
//        this.width_ = width;
//        this.height_ = height;
//        int[] vert = {1,1, this.width_,1, this.width_,this.height_, 1,this.height_};
//        Bloco bloco = new Bloco(0, 0, vert, "ret");
//        borderEntity = new Entity("borda", bloco ) {
//
//            public boolean colision() {
////                Iterator<Entity> it = Mapa.this.getEntityIterator();
////                Entity entidade = null;
////                while(it.hasNext()){
////                    entidade = it.next();
////                    if (this.intersects(entidade) ) {
////                        entidade.setOnMap(true);
////                        this.colisionAction(entidade);
////                    }
////                    else entidade.setOnMap(false);
////                }
//                return false;
//            }
//
//            @Override
//            public void colisionAction(Entity entidade) {
//                //entidade.setOnMap(true);
//            }
//        };
//        this.addEntity(borderEntity);
//    }
//
//    /*insercao de entidades que implementam colisao no mapa*/
//    public final void addEntity(Entity entidade){
//        entidades_.add(entidade);
//    }
//
//    public Iterator<Entity> getEntityIterator(){
//        return entidades_.iterator();
//    }
//
//    public int getX(){
//        return this.x_;
//    }
//
//    public void setX(int x){
//        this.x_ = x;
//    }
//
//    public int getY(){
//        return this.y_;
//    }
//    
//    public void setY(int y){
//        this.y_ = y;
//    }
//
//    public int getWidth(){
//        return this.width_;
//    }
//
//    public void setWidth(int width){
//        this.width_ = width;
//    }
//
//    public int getHeight(){
//        return this.height_;
//    }
//
//    public void setHeight(int height){
//        this.height_ = height;
//    }
//
//    public Entity getBorderEntity() {
//        return borderEntity;
//    }
//
//}
