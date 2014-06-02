/**
 * 
 */
package vo;

/**
 * @author Aaron ZHENG
 * @email fucheng.zheng@gmail.com
 * @createAt Jun 2, 2014 3:18:09 PM
 * @history 
 *
 */
public class RawData {

	private String date;
	private String content;
	
	
	
	/**
	 * @param date
	 * @param content
	 */
	public RawData(String date, String content) {
		this.date = date;
		this.content = content;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
