/*    */ import java.awt.BasicStroke;
/*    */ import java.awt.Color;
/*    */ import java.awt.GradientPaint;
/*    */ import java.awt.Paint;
/*    */ import java.awt.Point;
/*    */ import java.awt.Shape;
/*    */ import java.awt.geom.Arc2D;
/*    */ import java.awt.geom.GeneralPath;
/*    */ import java.awt.geom.Point2D;
/*    */ import java.awt.geom.Rectangle2D;

/**
 * Конструктор ShapeFactory имеет два переключателя, где переключатель (shape_type / 10)
 * Case 1 отвечает за создание шестиугольник
 * Case 3 отвечает за создание звезды
 * Case 5 отвечает за строительство квадрат
 * Case 7 отвечает за построение треугольника
 * Case 9 отвечает за строительство круг без сектора
 *
 * Где переключатель (shape_type / 10)
 * Case 4 увеличивает контуры
 * Case 7 отвечает за серо-белый градиент
 * Case 8 Подготовка форм красный
 ** /




/*    */ public class ShapeFactory
/*    */ {
/*    */   public Shape shape;
/*    */   public BasicStroke stroke;
/*    */   public Paint paint;
/*  9 */   public int width = 25;
/* 10 */   public int height = 25;
/*    */ 
/*    */   public ShapeFactory(int shape_type) {
/* 13 */     this.stroke = new BasicStroke(3.0F);
/* 14 */     switch (shape_type / 10) {
/*    */     case 1:
/* 16 */       this.shape = createStar(3, new Point(0, 0), this.width / 2.0D, this.width / 2.0D);
/* 17 */       break;
/*    */     case 3:
/* 19 */       this.shape = createStar(5, new Point(0, 0), this.width / 2.0D, this.width / 4.0D);
/* 20 */       break;
/*    */     case 5:
/* 22 */       this.shape = new Rectangle2D.Double(-this.width / 2.0D, -this.height / 2.0D, this.width, this.height);
/* 23 */       break;
/*    */     case 7:
/* 25 */       GeneralPath path = new GeneralPath();
/* 26 */       double tmp_height = Math.sqrt(2.0D) / 2.0D * this.height;
/* 27 */       path.moveTo(-this.width / 2, -tmp_height);
/* 28 */       path.lineTo(0.0D, -tmp_height);
/* 29 */       path.lineTo(this.width / 2, tmp_height);
/* 30 */       path.closePath();
/* 31 */       this.shape = path;
/* 32 */       break;
/*    */     case 9:
/* 34 */       this.shape = new Arc2D.Double(-this.width / 2.0D, -this.height / 2.0D, this.width, this.height, 30.0D, 300.0D, 
/* 35 */         2);
/* 36 */       break;
/*    */     case 2:
/*    */     case 4:
/*    */     case 6:
/*    */     case 8:
/*    */     default:
/* 39 */       throw new Error("type is nusupported");
/*    */     }
/* 41 */     switch (shape_type % 10) { case 1:
/* 42 */       this.stroke = new BasicStroke(3.0F);
/* 43 */       break;
/*    */     case 3:
/* 45 */       break;
/*    */     case 4:
/* 46 */       this.stroke = new BasicStroke(7.0F);
/* 47 */       break;
/*    */     case 7:
/* 49 */       this.paint = new GradientPaint(
/* 50 */         -this.width, -this.height, Color.white, 
/* 51 */         this.width, this.height, Color.gray, true);
/* 52 */       break;
/*    */     case 8:
/* 54 */       this.paint = Color.red;
/* 55 */       break;
/*    */     case 2:
/*    */     case 5:
/*    */     case 6:
/*    */     default:
/* 57 */       throw new Error("type is nusupported");
/*    */     }
/*    */   }
/*    */ 
/*    */   private static Shape createStar(int arms, Point center, double rOuter, double rInner)
/*    */   {
/* 63 */     double angle = 3.141592653589793D / arms;
/*    */ 
/* 65 */     GeneralPath path = new GeneralPath();
/*    */ 
/* 67 */     for (int i = 0; i < 2 * arms; i++)
/*    */     {
/* 69 */       double r = (i & 0x1) == 0 ? rOuter : rInner;
/* 70 */       Point2D.Double p = new Point2D.Double(center.x + Math.cos(i * angle) * r, center.y + Math.sin(i * angle) * r);
/* 71 */       if (i == 0) path.moveTo(p.getX(), p.getY()); else
/* 72 */         path.lineTo(p.getX(), p.getY());
/*    */     }
/* 74 */     path.closePath();
/* 75 */     return path;
/*    */   }
/*    */ }

/* Location:           C:\USER\in22_10\lab3.jar
 * Qualified Name:     ShapeFactory
 * JD-Core Version:    0.6.2
 */