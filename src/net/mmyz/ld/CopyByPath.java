package net.mmyz.ld;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class CopyByPath {

	public  static void Copy(String ipath,String opath) {		

		//�ж��Ƿ���·���õ�
		boolean is = false;
		//���ڻ�ȡĿ���ļ��ж���
		File aimDir = new File(ipath);

		do {
			//�ж�D���Ƿ����
			is = aimDir.exists();
			if (is == false) {
				System.out.println("������·��");				
			}
		} while (is == false);

		//����ļ���opath
		File toDir = new File(opath+"/done");
		if (toDir.exists() == false) {
			toDir.mkdir();
		}
		System.out.println("��ʼ��ȡ��");
		try {

				FileUtils.copyDirectory(aimDir,toDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("��ȡ��ɣ�");
	}
}

