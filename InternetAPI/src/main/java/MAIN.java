import java.util.Arrays;
import java.util.Scanner;
public class dfs
{
    public static void main(String[] args)
    {

        struct node{ long data; node *left; node *right; };
        typedef node *tree; tree root;
        long count; tree find (tree temp, long val){ if(temp==NULL){

        return temp;
    }
    else if (temp -> data == val) return temp;
    else if (temp -> data < val && temp -> right != NULL) return find(temp -> right, val);
    else if (temp -> data > val && temp -> left != NULL) return find(temp -> left, val);
    else {
        return temp;
    }
    }
        void insert(long val) {
        tree place, temp;
        place = find(root, val);
        if (place == NULL) {
            root = (tree) malloc(sizeof(node));
            root -> data = val;
            root -> left = NULL;
            root -> right = NULL;
            count++;
        } else if (place -> data > val) {
            place -> left = (tree) malloc(sizeof(node));
            place -> left -> data = val;
            place -> left -> left = NULL;
            place -> left -> right = NULL;
        } else if (place -> data < val) {
            place -> right = (tree) malloc(sizeof(node));
            place -> right -> left = NULL;
            place -> right -> right = NULL;
            place -> right -> data = val;

        }

    }
        void print(tree temp) {
        if (temp == NULL) return;
        else {

            print(temp -> left);
            print(temp -> right);
        }
    }
        long maxDepth(tree node) {
        if (node == NULL) {
            return 0;
            count++;
        } else {

            long lDepth = maxDepth(node -> left);
            long rDepth = maxDepth(node -> right);

            if (lDepth > rDepth) return (lDepth + 1);
            else return (rDepth + 1);
        }
    }

        int main() {
        long n, m, t, k;
        cin >> t;
        long i;
        for (i = 0; i < t; i++) {
            root = NULL;
            cin >> n;
            for (int j = 0; j < n; j++) {
                cin >> k;
                insert(k);
            }
            cout << maxDepth(root) << "\n";

        }

        return 0;
    }
    }
}