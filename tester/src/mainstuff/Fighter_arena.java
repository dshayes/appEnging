/*     */ package mainstuff;

/*     */ public class Fighter_arena
/*     */   
/*     */ {
			
/*     */   private Fighter playerOne;
/*     */   private Fighter playerTwo;
/*     */   private Item randomItem;
/*     */   private StringBuffer fighterLog;
/*     */   private Item PlayerOneItem;
/*     */   private Item PlayerTwoItem;
/*     */   private Action ac;
/*     */   
/*     */   private BattleLog bT;
/*     */ 
/*     */   Fighter_arena(Fighter playerOne, Fighter playerTwo)
/*     */   {
/*  16 */     this.playerOne = playerOne;
/*  17 */     this.playerTwo = playerTwo;
/*  18 */     this.fighterLog = new StringBuffer();
/*     */ 
/*  20 */     if (playerOne.getFighterItem().getItemType() == 1)
/*  21 */       this.PlayerOneItem = playerOne.getFighterItem();
/*     */     else {
/*  23 */       this.PlayerOneItem = playerOne.getFighterItemTwo();
/*     */     }
/*     */ 
/*  26 */     if (playerTwo.getFighterItem().getItemType() == 1)
/*  27 */       this.PlayerOneItem = playerTwo.getFighterItem();
/*     */     else
/*  29 */       this.PlayerOneItem = playerTwo.getFighterItemTwo();
/*  30 */     this.bT = new BattleLog();
/*  31 */     this.ac = new Action();
/*     */ 
/*  34 */     
/*  35 */     System.out.println("chiled thread started, fighter arena");
/*  36 */     
/*     */   }
/*     */ 
/*     */   public Fighter getPlayerOne()
/*     */   {
/*  43 */     return this.playerOne;
/*     */   }
/*     */ 
/*     */   public void setPlayerOne(Fighter playerOne)
/*     */   {
/*  49 */     this.playerOne = playerOne;
/*     */   }
/*     */ 
/*     */   public Fighter getPlayerTwo()
/*     */   {
/*  55 */     return this.playerTwo;
/*     */   }
/*     */ 
/*     */   public void setPlayerTwo(Fighter playerTwo)
/*     */   {
/*  61 */     this.playerTwo = playerTwo;
/*     */   }
/*     */ 
/*     */   public Item getRandomItem()
/*     */   {
/*  67 */     return this.randomItem;
/*     */   }
/*     */ 
/*     */   public void setRandomItem(Item randomItem)
/*     */   {
/*  73 */     this.randomItem = randomItem;
/*     */   }
/*     */ 
/*     */   public StringBuffer getFighterLog()
/*     */   {
/*  79 */     return this.fighterLog;
/*     */   }
/*     */ 
/*     */   public void setFighterLog(StringBuffer fighterLog)
/*     */   {
/*  85 */     this.fighterLog = fighterLog;
/*     */   }
/*     */ 
/*     */   public Item getPlayerOneItem()
/*     */   {
/*  92 */     return this.PlayerOneItem;
/*     */   }
/*     */ 
/*     */   public void setPlayerOneItem(Item playerOneItem)
/*     */   {
/*  98 */     this.PlayerOneItem = playerOneItem;
/*     */   }
/*     */ 
/*     */   public Item getPlayerTwoItem()
/*     */   {
/* 104 */     return this.PlayerTwoItem;
/*     */   }
/*     */ 
/*     */   public void setPlayerTwoItem(Item playerTwoItem)
/*     */   {
/* 110 */     this.PlayerTwoItem = playerTwoItem;
/*     */   }
/*     */ 
/*     */   public void mainEvent() {
/* 114 */     int playerOneSpeed = 60 / this.playerOne.getSpeed();
/* 115 */     int playerTwoSpeed = 60 / this.playerTwo.getSpeed();
/* 116 */     int i = 1;
/* 117 */     String str = this.playerOne.getName() + "s health is " + String.valueOf(this.playerOne.getHealth()) + " && " + this.playerTwo.getName() + "s health is " + String.valueOf(this.playerTwo.getHealth()) + " |";
/* 118 */     this.ac.setFighterLog(str);
/*     */ 
/* 120 */     while ((this.playerOne.getHealth() > 0) && (this.playerTwo.getHealth() > 0))
/*     */     {
/* 122 */       if (i % playerOneSpeed == 0)
/*     */       {
/* 124 */         this.playerTwo.setHealth(this.playerTwo.getHealth() - this.ac.performAction(this.playerOne));
/* 125 */         String str2 = this.playerOne.getName() + "s remaining health is " + String.valueOf(this.playerOne.getHealth()) + " && " + this.playerTwo.getName() + "s remaining health is " + String.valueOf(this.playerTwo.getHealth()) + " |";
/* 126 */         this.ac.setFighterLog(str2);
/*     */       }
/*     */ 
/* 130 */       if ((i % playerTwoSpeed == 0) && (this.playerTwo.getHealth() > 0)) {
/* 131 */         this.playerOne.setHealth(this.playerOne.getHealth() - this.ac.performAction(this.playerTwo));
/* 132 */         String str2 = this.playerOne.getName() + "s remaining health is " + String.valueOf(this.playerOne.getHealth()) + " && " + this.playerTwo.getName() + "s remaining health is " + String.valueOf(this.playerTwo.getHealth()) + " |";
/* 133 */         this.ac.setFighterLog(str2);
/*     */       }
/*     */ 
/* 137 */       this.fighterLog = this.ac.getFighterLog();
/* 138 */       System.out.println(this.fighterLog);
/* 139 */       i++;
/*     */     }
/*     */ 
/* 142 */     if (this.playerOne.getHealth() <= 0) {
/* 143 */       this.fighterLog.append(this.playerTwo.getName() + " has won!!!! :-) |");
/* 144 */       this.bT.setVictorID(this.playerTwo.getCharater_ID());
/*     */ 
/* 146 */       Item vItem = new Item(this.playerTwo.getXp() / 10 + 1);
/* 147 */       this.bT.setVictorItem(vItem);
/* 148 */       this.bT.setLoserID(this.playerOne.getCharater_ID());
/*     */ 
/* 150 */       this.bT.setGainsXPV(10 + this.playerTwo.getXp());
/* 151 */       this.bT.setGainsXPL(10 + this.playerOne.getXp());
/*     */     }
/*     */     else {
/* 154 */       this.fighterLog.append(this.playerOne.getName() + " has WON!!! :-) |");
/* 155 */       this.bT.setVictorID(this.playerOne.getCharater_ID());
/* 156 */       Item vItem = new Item(this.playerOne.getXp() / 10 + 1);
/* 157 */       this.bT.setVictorItem(vItem);
/* 158 */       this.bT.setLoserID(this.playerTwo.getCharater_ID());
/*     */ 
/* 160 */       this.bT.setGainsXPV(10 + this.playerOne.getXp());
/* 161 */       this.bT.setGainsXPL(10 + this.playerTwo.getXp());
/*     */     }
/*     */ 
/* 165 */     this.bT.setBattleLog(this.fighterLog);
/*     */     try
/*     */     {
/* 169 */       this.bT.updateDatabase();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/* 172 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 

/*     */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.Fighter_arena
 * JD-Core Version:    0.6.2
 */