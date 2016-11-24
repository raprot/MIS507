public abstract class GameType{
  
  double ante;//Double variable to capture the current table ante.
  
  String type;//String variable to capture the current game type.
  
  abstract public void setAnte(double ante);
  //Abstract setter to set a table ante.
  
  abstract public double getAnte();
  //Abstract getter for the ante variable.
  
  abstract public void setType(String type);
  //Abstract setter for the type variable.
  
  abstract public String getType();
  //Abstract getter for the type variable.
  
  abstract public String toString();
  //Abstract AF implementation.
  
  abstract public boolean repOK();
  //Abstract RI implementation.
}