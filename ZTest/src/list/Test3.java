package list;

import java.io.*;

/*
 * 다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
 * 다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
 * 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. 
 * (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
*/

public class Test3 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String roomNum = br.readLine();
		
		int maxCnt = 0;
		
		for(char c = '0'; c <= '8'; c++) {
			int cnt = 0;
			
			if(c == '6') {
				for(int j = 0; j < roomNum.length(); j++) {
					if(c == roomNum.charAt(j) || '9' == roomNum.charAt(j))
						cnt++;
				}
			}
			else {
				for(int j = 0; j < roomNum.length(); j++) {
					if(c == roomNum.charAt(j)) 
						cnt++;
				}
			}
			if(c == '6') {
				cnt = cnt % 2 == 0 ? cnt / 2 : cnt / 2 + 1;
			}
			if(maxCnt <= cnt) {
				maxCnt = cnt;
			}
		}
		System.out.print(maxCnt);
		bw.flush();
		
	}
	
}
