package net.mmyz.ld;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class CopyByWords {

	public  static void Copy(String[] words,String disk,String opath) {		

		//�ж��Ƿ�����̷��õ�
		boolean is = false;
		//���ڻ�ȡ��Ŀ¼�������ļ�����
		File[] rootAllDir = null;

		//�ж��ļ������Ƿ��ܼ�¼��Ŀ���ļ�������
		boolean canBeRecorded = false;
		//�洢Ŀ���ļ�����
		ArrayList<File>aimDir = new ArrayList<File>();


		do {
			//�ж�D���Ƿ����
			is = new File(disk+"/").exists();
			if (is == true) {
				//���D���ļ����б�
				rootAllDir = new File(disk+"/").listFiles();
				for (int i = 0; i < rootAllDir.length; i++) {
					for (int j = 0; j < words.length; j++) {
						if(rootAllDir[i].getName().indexOf(words[j]) == -1){
							System.out.println("�ļ�����"+i+"������"+words[j]);
							canBeRecorded = false;
							break;
						}else{
							System.out.println("�ļ�����"+i+"����"+words[j]+"!!!!!!!!!!!!!!!!!!!");
							canBeRecorded = true;
						}
					}
					if (canBeRecorded == true) {
						aimDir.add(new File(disk+"/"+rootAllDir[i].getName()+"/������Ʒ"));
					}
				}
				int k = 0;
				while (k<aimDir.size()) {
					if (aimDir.get(k).exists() == true) {
						System.out.println("Ŀ�����"+k+"���ڣ������²��ж�");
						System.out.println(aimDir.get(k).getAbsolutePath());
						if (aimDir.get(k).isDirectory() == true) {
							System.out.println("Ŀ�����"+k+"���ļ���");
							k++;
						}else {
							System.out.println("Ŀ�����"+k+"�����ļ��У�����Ҫ");
							aimDir.remove(k);
						}
					}else {
						System.out.println("Ŀ�����"+k+"�����ڣ�");						
						aimDir.remove(k);
					}
				}
				if (aimDir.size() == 0) {
					//���Ŀ�����û�з��ϵģ������»ص���һ��ѭ����ʼ�ж�
					is=false;
					System.out.println("û�з��ϵ�Ŀ����������ж�");
				}
			}else{
				System.out.println("�������̷�");
			}
		} while (is == false);
		//����ļ���opath

		File toDir = new File(opath+"/done");
		if (toDir.exists() == false) {
			toDir.mkdir();
		}
		System.out.println("��ʼ��ȡ��");
		try {
			//�����ļ���
			for (int i = 0; i < aimDir.size(); i++) {
				FileUtils.copyDirectory(aimDir.get(i), toDir);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("��ȡ��ɣ�");
	}
}

