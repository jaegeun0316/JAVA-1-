����   4 �  utilTest/ArrayTest  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this LutilTest/ArrayTest; main ([Ljava/lang/String;)V  java/util/ArrayList
  	
    java/lang/Integer   valueOf (I)Ljava/lang/Integer;
     add (Ljava/lang/Object;)Z  안녕@	������
 " $ # java/lang/Double  % (D)Ljava/lang/Double;	 ' ) ( java/lang/System * + out Ljava/io/PrintStream; - java/lang/StringBuilder / 마지막 : 
 , 1  2 (Ljava/lang/String;)V
  4 5 6 size ()I
  8 9 : get (I)Ljava/lang/Object;
 , < = > append -(Ljava/lang/Object;)Ljava/lang/StringBuilder;
 , @ A B toString ()Ljava/lang/String;
 D F E java/io/PrintStream G 2 println
 D I G J (I)V
  L  J N 	크기 : 
 , P = Q (I)Ljava/lang/StringBuilder;
  S T : remove
  V T  X 지금자바
  Z  [ (ILjava/lang/Object;)V ] 자바 _ JAVA a java/lang/String
 D c G 
  e f g iterator ()Ljava/util/Iterator; i k j java/util/Iterator l m next ()Ljava/lang/Object;
 ` o  p &(Ljava/lang/Object;)Ljava/lang/String; r 	
 , t = u -(Ljava/lang/String;)Ljava/lang/StringBuilder; i w x y hasNext ()Z
  { | 6 intValue
 ` ~   (I)Ljava/lang/String; args [Ljava/lang/String; arr Ljava/util/ArrayList; list alist i I s Ljava/lang/String; LocalVariableTypeTable *Ljava/util/ArrayList<Ljava/lang/Integer;>; )Ljava/util/ArrayList<Ljava/lang/String;>; StackMapTable � 
SourceFile ArrayTest.java !               /     *� �    
                    	      �    �� Y� L+� � W+� W+ � !� W� &� ,Y.� 0++� 3d� 7� ;� ?� C� &+� 3� H+� Y� K� W� &� ,YM� 0+� 3� O� ?� C� &� ,Y.� 0++� 3d� 7� ;� ?� C+� RW+� UW� &� ,YM� 0+� 3� O� ?� C+W� Y� &� ,YM� 0+� 3� O� ?� C� Y� M,� � W,� � W� Y� N-\� W-^� W6� � &-� 7� `� C�-� 3��� &� b-� d:� )� h � `:� &� ,Y� n� 0q� s� ?� C� v ��Ӳ &� b,� d:� ,� h � � z6� &� ,Y� }� 0q� s� ?� C� v ��б    
   �       	  
   #  B  L  Y  r  �  �  �  �  �  �  �  �  �  �      ( .  C !]  g #m $� %� $� )    H   � � �   � � �  � � � �  � � � � 
  � � C  � � �  � �  �     � � � �  � � � �  �   1 �  �     �   �     i  %(  �    �