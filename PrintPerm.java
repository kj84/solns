/*
* {first, second} is before {first1, second1} followed by 
* Expected Output is to generate all permutations of words in the {} 
*/

public static class PrintPerm {
  
    public static void printPerm(String str) {
      Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        int count = 0;
        List<List<String>> words = new ArrayList<>();
        while(matcher.find()) {

            String group = matcher.group(1).trim();
            words.add(new ArrayList<String>(Arrays.asList(group.split(","))));

            matcher.appendReplacement(sb, "{" + count + "}");
            count++;
        }
        matcher.appendTail(sb);

        String[] buf = new String[words.size()];
        genPerm(words, 0, buf,sb.toString());
    }

    private static void genPerm(List<List<String>> words, int in, String[] buf, String msg) {
        if(in == words.size()) {
            System.out.println(MessageFormat.format(msg, buf));
            return;
        }

            for(int i = 0 ; i < words.get(in).size(); i++) {
                buf[in] =  words.get(in).get(i);
                genPerm(words, in+1, buf, msg);
            }
    }

    public static void main(String[] args) throws Exception {
        printPerm("{first, second} is before {first1, second1, thrid1} followed by {first2, second2} testing ");
    }
}
