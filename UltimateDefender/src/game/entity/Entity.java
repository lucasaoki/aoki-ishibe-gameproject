/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.Component;
import game.component.characters.CharacterInfo;
import game.component.characters.CharsMoves;
import game.component.render.RenderComponent;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Classe de entidades do jogo.
 * @author Lucas
 */
public class Entity {
//checar se colocar private afetou algo
    private String id;
    private Point position;
    private float scale;
    private Rectangle box;
    private RenderComponent renderComponent = null;
    private ArrayList<Component> components = null;
    private CharacterInfo charInfoComp = null;
 
    /**
     * Entidades carregam sua componentes, posição, caixa de colisão
     */
    public Entity(String id) {
        this.id = id;
        position = new Point(0, 0);
        box = new Rectangle();
        components = new ArrayList<>();
        scale = 1.5f;
    }

    /**
     * Função para adicionar nova componente à entidade.
     * @param component 
     */
    public void addComponent(Component component) {
        if (RenderComponent.class.isInstance(component)) {
            renderComponent = (RenderComponent) component;
        }
        if (CharacterInfo.class.isInstance(component)) {
            charInfoComp = (CharacterInfo) component;
        }
        component.setOwnerEntity(this);
        components.add(component);
    }

    /**
     * Busca de uma componente
     * @param id
     * id da componente à ser buscada
     * @return 
     * Retorna a componente se encontrada
     */
    public Component getComponent(String id) {
        for (Component comp : components) {
            if (comp.getID().equalsIgnoreCase(id)) {
                return comp;
            }
        }
        return null;
    }

    /**
     * Função que pega as informações da entidade
     * @return 
     * Retorna informações da entidade
     */
    public CharacterInfo getCharInfo() {
        return charInfoComp;
    }

    /**
     * Informa a posição
     * @return 
     * Retorna a posição
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Pega id
     * @return
     * Retorna id
     */
    public String getId() {
        return id;
    }

    /**
     * Escala da entidade
     * @return 
     * Retorna a escala
     */
    public float getScale() {
        return scale;
    }

    /**
     * Caixa de colisão
     * @return 
     * Retorna a caixa de colisão
     */
    public Rectangle getColisionBox() {
        return box;
    }

    /**
     * Seta a caixa de colisão do personagem
     * @param box 
     * Caixa de colisão
     */
    public void setColisionBox(Rectangle box) {
        this.box = box;
    }

    /**
     * Seta a escala da entidade
     * @param scale 
     * Escala da entidade
     */
    public void setScale(float scale) {
        this.scale = scale;
    }

    /**
     * Seta a posição da entidade
     * @param position 
     * Posição da entidade
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Função para checar colisão entre entidades
     * @param entity
     * Entidade para checar colisão
     * @return 
     * Retorna se houve colisão
     */
    public boolean intersects(Entity entity) {
        return this.intersects(entity.getColisionBox());
    }

    /**
     * Função para checar colisão entre as caixas de colisão
     * @param box
     * Caixa de colisão
     * @return 
     * Se houve colisão
     */
    public boolean intersects(Rectangle box) {
        return this.getColisionBox().intersects(box);
    }

    /**
     * Leitura da animação dos personagens
     * @param move
     * Movimento à ser lido
     * @param num
     * Quantidade de frames da animação
     * @return 
     * Retorna a animação
     */
    public Image[] readFrames(String move, int num) {
        Image tmp[] = new Image[num];
        for (int i = 1; i <= num; i++) {
            String filename = "/images/" + this.getId() + "/" + move + " (" + i + ").png";
            URL url = CharsMoves.class.getResource(filename);
            tmp[i - 1] = (new ImageIcon(url)).getImage();
        }
        return tmp;
    }

    /**
     * Chama o update das componente do personagem
     */
    public void update() {
        for (Component component : components) {
            component.update();
        }
    }

    /**
     * Chama o render das componentes do personagem
     * @param gr 
     */
    public void render(Graphics2D gr) {
        if (renderComponent != null) {
            renderComponent.render(gr);
        }
    }
}
