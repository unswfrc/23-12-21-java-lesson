/*
* created by: Joel Perry, 45626715
*            joel.perry@students.mq.edu.au
* last edited: 22/09/21
*
* based on provided COMP2000 code with addaptaion by joel
* Changes covered in ABOVE_AND_BEYOND.md under Trio
*/

/** Generic class able to hold 3 of any types*/
public class Trio<L,M,R> {
  private L left;
  private M middle;
  private R right;

  /** Creates new trio
  * @param L left datatype
  * @param l data to go in left
  * @param M middle datatype
  * @param m data to go in middle
  * @param R right datatype
  * @param r data to go in right
  */
  public Trio(L l, M m, R r) {
    left = l;
    middle = m;
    right = r;
  }

  /** gets data from left
  * @param L left datatype
  * @return data in left
  */
  public L getLeft() {
    return left;
  }
  /** gets data from middle
  * @param M middle datatype
  * @return data in middle
  */
  public M getMiddle() {
    return middle;
  }
  /** gets data from right
  * @param R right datatype
  * @return data in right
  */
  public R getRight() {
    return right;
  }

  /** sets data to left
  * @param L left datatype
  * @param l data to go in left
  */
  public void setLeft(L l) {
    left = l;
  }
  /** sets data to middle
  * @param M middle datatype
  * @param m data to go in middle
  */
  public void setMiddle(M m) {
    middle = m;
  }
  /** sets data to right
  * @param R right datatype
  * @param r data to go in right
  */
  public void setRight(R r) {
    right = r;
  }
}