/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ public class TitlesFrame extends JFrame
/*    */ {
/*    */   public TitlesFrame()
/*    */   {
/*  7 */     initUI();
/*    */   }
/*    */ 
/*    */   private void initUI()
/*    */   {
/* 12 */     setTitle("Кривые фигуры");
/* 13 */     setDefaultCloseOperation(3);
/* 14 */     add(new TitlesPanel(31));
/* 15 */     setSize(350, 350);
/* 16 */     setLocationRelativeTo(null);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 21 */     SwingUtilities.invokeLater(new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
/* 25 */         TitlesFrame ps = new TitlesFrame();
/* 26 */         ps.setVisible(true);
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           C:\USER\in22_10\lab3.jar
 * Qualified Name:     TitlesFrame
 * JD-Core Version:    0.6.2
 */