/**
 * 
 */
package com.luffycat.www.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import vo.RawData;

/**
 * @author Aaron ZHENG
 * @email fucheng.zheng@gmail.com
 * @createAt May 24, 2014 5:51:44 PM
 * @history 
 *
 */
public class AutoGenerate {
	//default value
	private static final String SEPARATOR = "/";
	private static final String CLASSES = "/classes";
	private static final String BLANK = "";
	private static final String SPACE = " ";
	private static final String SPACE_KEY = "%20";
	private static final int PERIOD = 5;
	//general path
	private static final String PATH_DATA = "data/";
	private static final String PATH_MENU_ITEM = "menu_item/";
	//data path
	private static final String PATH_DRAW = PATH_DATA + "draw.data";
	private static final String PATH_PORTFOLIO = PATH_DATA + "portfolio.data";
	private static final String PATH_STORY = PATH_DATA + "story.data";
	//out put path
	private static final String OUTPUT_DRAW = PATH_MENU_ITEM + "draw.luffycat";
	private static final String OUTPUT_POFOLIO = PATH_MENU_ITEM + "portfolio.luffycat";
	private static final String OUTPUT_STORY = PATH_MENU_ITEM + "story.luffycat";
	
	
	public static void main(String[] args){
		outputDraw();
		outputStory();
		outputPortfolio();
	}
	
	
	
	private static void outputDraw(){
		List<RawData> list = getContent(PATH_DRAW, PERIOD);
		StringBuffer result = new StringBuffer();
		result.append("<article class='page type-page status-publish has-post-thumbnail hentry'> \n");
		result.append("<img id='div_profile_details' src='./images/background/draw.jpg' style='width:1400px;'/>	\n");
		result.append("<img id='img1' src='./images/main/"+list.get(0).getDate()+".jpg' class='img_draw' /> \n");
		for(int i = 0; i < PERIOD; i++){
			result.append("<img id='img"+(i+2)+"' src='./images/thumb/"+list.get(i).getDate()+".jpg' class='img_draw' /> \n");
		}
		result.append("</article> \n");
		result.append("<script type='text/javascript' src='./js/main/draw.js'></script> \n");
		outputContent(OUTPUT_DRAW, result.toString());
	}
	
	private static void outputStory(){
		List<RawData> list = getContent(PATH_STORY, PERIOD);
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < PERIOD; i++){
			result.append("<header class='entry-header'> \n");
			result.append("	<div class='entry-meta'> \n");
			result.append("		<span class='posted-on'> \n");
			result.append("		<time class='entry-date published' datetime='"+list.get(i).getDate()+"'> \n");
			result.append("		<a href='#' rel='bookmark'>"+list.get(i).getDate()+"</a> \n");
			result.append("		</time><timed class='updated' datetime='"+list.get(i).getDate()+"'>"+list.get(i).getDate()+"</timed></span> \n");
			result.append("	</div> \n");
			result.append("</header> \n");
			result.append("<article class='page type-page status-publish has-post-thumbnail hentry'> \n");
			result.append("	<figure class='post-thumb'>	 \n");
			result.append("		<div class='entry-content' style='color:#ffffff'>"+list.get(i).getContent()+"</div> \n");
			result.append("	</figure> \n");
			result.append("</article>	 \n");
		}
		outputContent(OUTPUT_STORY, result.toString());
	}
	
	private static void outputPortfolio(){
		List<RawData> list = getContent(PATH_PORTFOLIO, PERIOD);
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < PERIOD; i++){
			result.append("<header class='entry-header'> \n");
			result.append("	<div class='entry-meta'> \n");
			result.append("		<span class='posted-on'> \n");
			result.append("		<time class='entry-date published' datetime='"+list.get(i).getDate()+"'> \n");
			result.append("		<a href='#' rel='bookmark'>"+list.get(i).getDate()+"</a> \n");
			result.append("		</time><timed class='updated' datetime='"+list.get(i).getDate()+"'>"+list.get(i).getDate()+"</timed></span> \n");
			result.append("	</div> \n");
			result.append("</header> \n");
			result.append("<article class='post type-post status-publish format-standard has-post-thumbnail hentry category-standard tag-featured-image tag-no-format tag-standard-2'> \n");
			result.append("	<figure class='post-thumb'>	 \n");
			result.append("		<img width='1200' height='675' src='./images/porfolio/"+list.get(i).getDate()+".jpg' class='attachment-post-thumbnail wp-post-image' alt='empire-state-building'> \n");
			result.append("		<div class='entry-content' style='color:#ffffff'> \n");
			result.append("			<p>"+list.get(i).getContent()+"</p> \n");
			result.append("		</div> \n");
			result.append("	</figure> \n");
			result.append("</article> \n");
		}
		outputContent(OUTPUT_POFOLIO, result.toString());
	}
	
	private static void outputContent(String contentPath, String content){
		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
 		try{
			String path = getRealPath(contentPath).replace("WEB-INF/", "");
			fileOutputStream = new FileOutputStream(new File(path));
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			bufferedOutputStream.write(content.getBytes());
			bufferedOutputStream.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				fileOutputStream.close();
				bufferedOutputStream.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	private static List<RawData> getContent(String contentPath, int number){
		List<RawData> result = new ArrayList<RawData>();
		BufferedReader reader = null;
		InputStreamReader read = null;
		try{
			String path = getRealPath(contentPath);
			read = new InputStreamReader(new FileInputStream(path), "UTF-8");
			reader = new BufferedReader(read);
			String line;
			int firstIndex;
			for(int i = number; i > 0; i--){
				line = reader.readLine();
				firstIndex = line.indexOf(SEPARATOR);
				if(firstIndex == -1){
					result.add(new RawData(line, null));
				}else{
					result.add(new RawData(
							line.substring(0, firstIndex), 
							line.substring(firstIndex + 1)));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				read.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private static String getRealPath(String path){
		String prefixPath = AutoGenerate.class.getResource(SEPARATOR)
				.getPath().replace(CLASSES,BLANK).replace(SPACE_KEY, SPACE);
		return prefixPath + path;
	}
	
}
