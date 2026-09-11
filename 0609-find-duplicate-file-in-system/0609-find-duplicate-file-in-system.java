class Solution { 
    public List<List<String>> findDuplicate(String[] paths) { 

        HashMap<String,List<String>> map = new HashMap<>(); 

        for(int i = 0; i < paths.length; i++) { 

            String root = ""; 
            int j = 0; 

            // Get directory
            while(paths[i].charAt(j) != ' ') {
                root += paths[i].charAt(j);
                j++;
            }

            // Skip the space
            j++;

            while(j < paths[i].length()) {

                // Build filename
                String file = "";

                while(j < paths[i].length() && paths[i].charAt(j) != ' ') {
                    file += paths[i].charAt(j);
                    j++;
                }

                // Find '('
                int start = file.indexOf('(');

                String fileName = file.substring(0, start);
                String content = file.substring(start + 1, file.length() - 1);

                String fullPath = root + "/" + fileName;

                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fullPath);

                j++; // skip space
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> list : map.values()) {
            if(list.size() > 1) {
                result.add(list);
            }
        }

        return result;
    }
}