
public class QuizProtocol {
	// 상태
	private static final int WAITING = 0;// 문제기다리는 상태
	private static final int PROBLEM = 1;// 문제푸는상태
	private static final int ANSWER = 2;// 문제를 맞추느상태
	private static final int NUMPROBLEM = 3;

	private int state = WAITING;
	private int currentProblem = 0;
	private String[] problems = { "네트워크 처리 패키지는?", "서버쪽 소켓 클래스는?", "인터넷에서 컴퓨터를 식별하는 주소는 ?" };
	private String[] answers = { "java.net", "ServerSocket", "IP주소" };

	public String process(String input) {
		String output = null;

		if (state == WAITING) {
			output = "퀴즈를 시작합니다.";
			state = PROBLEM;
		} else if (state == PROBLEM) {
			if (input.equalsIgnoreCase("y")) {
				output = problems[currentProblem];
				state = ANSWER;
			} else {
				state = WAITING;
				output = "quit";
			}
		} else if (state == ANSWER) {
			if (input.equalsIgnoreCase(answers[currentProblem])) {
				output = "정답입니다. 계속하시겠습니까?(y/n):";
				state = PROBLEM;
			} else {
				output = "오답입니다. 계속하시겠습니까?(y/n):";
				state = PROBLEM;
			}
			currentProblem = (currentProblem + 1) % NUMPROBLEM;
		}
		return output;

	}
}
