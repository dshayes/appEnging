/*    */ package mainstuff;
/*    */ 
/*    */ public class Tactics
/*    */ {
/*    */   private int[] fighterActionTable;
/*    */   private int maxHealth;
/*    */   private int healCD;
/*    */ 
/*    */   Tactics(int health)
/*    */   {
/* 12 */     this.fighterActionTable = new int[100];
/* 13 */     this.healCD = 0;
/* 14 */     this.maxHealth = health;
/*    */   }
/*    */ 
/*    */   public int[] getFighterActionTable()
/*    */   {
/* 21 */     return this.fighterActionTable;
/*    */   }
/*    */ 
/*    */   public void setFighterActionTable(int[] fighterActionTable)
/*    */   {
/* 28 */     this.fighterActionTable = fighterActionTable;
/*    */   }
/*    */ 
/*    */   public int getNextAction(int health)
/*    */   {
/* 38 */     for (int i = 1; i < this.fighterActionTable.length; i++) {
/* 39 */       double augHealth = this.maxHealth * this.fighterActionTable[i] * 0.01D;
/* 40 */       if (augHealth >= health) {
/* 41 */         if (i == 1) {
/* 42 */           if (this.healCD <= 0)
/*    */           {
/* 44 */             this.healCD = 5;
/* 45 */             return i;
/*    */           }
/*    */ 
/* 48 */           this.healCD -= 1;
/* 49 */           break;
/*    */         }
/* 51 */         this.healCD -= 1;
/* 52 */         return i;
/*    */       }
/*    */     }
/* 55 */     this.healCD -= 1;
/* 56 */     return 0;
/*    */   }
/*    */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.Tactics
 * JD-Core Version:    0.6.2
 */