Key Practices for Backtracking
1. Use a Helper Function: Keep the recursion logic separate from the main function.
2. Base Case: Clearly define the stopping condition.
3. Include/Exclude Strategy: Make decisions (choose or don't choose an element).
4. Backtrack Properly: Remove the last added element after recursion.
5. Pass Minimal Parameters: Use class variables when necessary to keep the function signature clean.



private void backtrack(int index) {
    // 1️⃣ Base Condition (if needed)
    if (someCondition) {  
        ans.add(new ArrayList<>(path));  // Store a valid result
        return;
    }

    // 2️⃣ Loop Through Candidates
    for (int i = index; i < nums.length; i++) {
        // 3️⃣ Choose the element
        path.add(nums[i]);

        // 4️⃣ Explore further (Recursive call)
        backtrack(i + 1);  

        // 5️⃣ Undo (Backtrack step)
        path.remove(path.size() - 1);
    }
}

Summary of Backtracking Variants
Problem Type	Base Condition Needed?	Key Difference
Subsets (All Sizes)	❌ No explicit base case	Store all subsets
Combinations (k size)	✅ path.size() == k	Store only size k subsets
Permutations	✅ path.size() == nums.length	Track used elements
Combination Sum	✅ sum == target	Recursion with sum constraint