package kata.spring.entity;

/**@ClassName: User
 * @Description:  
 */
public class User {
    private Long id;  
    private String name;
    /**
     * id
    */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * name
    */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }  
}
