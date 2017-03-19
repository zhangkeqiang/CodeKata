package kata.cucumber;

/**@ClassName: TaskManager
 * @Description:  
 */
public class TaskManager {

    int taskAll;
    int taskDone = 0;
    /**@method setTotal
     * @description 
     * @return void
    */
    public void setTotal(int total) {
        this.taskAll = total;
    }
    /**@method setDone
     * @description 
     * @return void
    */
    public void setDone(int finished) {
        this.taskDone = this.taskDone + finished;        
    }
    /**@method getLeft
     * @description 
     * @return Object
    */
    public int getLeft() {
        return this.taskAll - this.taskDone;
    }

}
