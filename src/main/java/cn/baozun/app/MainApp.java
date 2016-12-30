package cn.baozun.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainApp {
    static File parent;
    static String simpleName;
	public static void main(String[] args) throws FileNotFoundException, IOException {
	  //  String[] args=	new String[]{"cutt","e:\\temp\\hao.png"};
	    String type=OptType.JOIN.getCode();
	    String fileName="";
	    if(args.length>=2){
			 type=args[0];
			 fileName=args[1];
	    }else if(args.length==0){
	    	System.out.println("必须输入指定的文件名称!");
	    	return;
	    }else{
	    	fileName=args[0];
	    }

		File file = new File(fileName);
		simpleName=file.getName();
		parent=file.getParentFile();
		if("cut".equals(type)){
			metodCut(fileName);
		}else{
			methodMerge(fileName);
		}
      System.out.println("success!");
	}
	private static void metodCut(String fileName) throws FileNotFoundException, IOException {
		FileInputStream  in  =	new  FileInputStream(fileName);
		//获取后缀名.被切割的文件采用相同的文件扩展名
		int  pot=fileName.lastIndexOf('.');
		String sufix =fileName.substring(pot);
		//获得每份的容量大小
		int total = in.available();
		int sub=(int) Math.ceil(total/10);
		
		for (int i = 0; i <10; i++) {
			String subFileName=i+sufix;
			int len =0;
			byte [] b=new byte[sub];
			if((len=in.read(b))!=-1){
				FileOutputStream out = new FileOutputStream(new File(parent,subFileName));
				out.write(b, 0, len);
				out.close();
			}
		}
		in.close();
	}
	
	private static void methodMerge(String fileName) throws IOException{

		//获取后缀名.被切割的文件采用相同的文件扩展名
		int  pot=fileName.lastIndexOf('.');
		String sufix =fileName.substring(pot);
		FileOutputStream out = new FileOutputStream(new File(parent,"copy_"+simpleName));
		for (int i = 0; i < 10; i++) {
			try {
				File f=new File(parent,i+sufix);
				if(!f.exists()) continue;
				FileInputStream in = new FileInputStream(new File(parent,i+sufix));
				int len=0;
			    byte[] b =	new byte[1024*5];
				while((len=in.read(b))!=-1){
					try {
						out.write(b, 0, len);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				in.close();
				new File(parent,i+sufix).delete();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		out.close();
	}
}
