package net.mmyz.ld;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class CopyDirectory {
	 //����Ŀ���ļ���
	public static void main(String[] args) {
		String getDirName;
		int j = 0;
		ArrayList<File>aimDir = new ArrayList<>();
		
		//������D��
		File dir = new File("F:/");
		boolean is;
		
		File[] allDir = null;
		
		do {
			//�ж�D���Ƿ����
			is = dir.exists();
			if (is == true) {
				//���D���ļ����б�
				allDir = dir.listFiles();
				for (int i = 0; i < allDir.length; i++) {
					getDirName = allDir[i].getName();
					//�����ؼ���
					if (getDirName.indexOf("�߶�") != -1){
						if (getDirName.indexOf("DV") != -1){
							if (getDirName.indexOf("2014") != -1){
								if(allDir[i].isDirectory() == true){
										aimDir.add(new File(allDir[i].getAbsolutePath()+"/������Ʒ"));
											if (aimDir.get(j).exists() == true) {
												j++;
												is = true;
											}else {
												aimDir.remove(j);
												System.out.println("������������Ʒ");
											}
								}else {
									System.out.println("�����ļ���");
//									is = false;
								}
							}else {
								System.out.println("������2014");
//								is = false;
							}
						}else {
							System.out.println("������DV");
//							is = false;
						}
					}else {
						System.out.println("�����ڸ߶�");
//						is = false;
					}
				}
			}else{
				System.out.println("������·��");
			}
		} while (is == false);
		//����ļ���
		//������G:/�߶���20��/done
		File toDir = new File("C:/Users/Administrator/Desktop/done");
		if (toDir.exists() == false) {
			toDir.mkdir();
		}
		try {
			//�����ļ���
			for (int i = 0; i < aimDir.size(); i++) {
					FileUtils.copyDirectory(aimDir.get(i), toDir);

				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
