package learning.algorithm.discount;

public interface UserService {

    /**
     *
     * @param userId
     * @return 0 if discount doesn't exist. 0 <= discount <= 99.
     */
    int discount(int userId);
}
