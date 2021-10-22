package com.example.jayant.student;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;


        @Service
        public class UserService {


            private final UserRepo userrepo;

            @Autowired
            public UserService(UserRepo userrepo) {
                this.userrepo = userrepo;
            }

            public List<User> getUser()
            {
                return userrepo.findAll();   //return list
            }

            public void addNewUser(User user) {
        //      Optional<Student> studentByEmail= StudentRepo.findStudentByEmail(student.getEmail());
        //      if(studentByEmail.isPresent())
        //      {
        //          throw new IllegalStateException("email taken");
        //      }
                userrepo.save(user);
                System.out.println(user);
            }



            public int deleteUser(int userid) {

                boolean exist = userrepo.existsById(userid);

                if(!exist)
                {
                    throw new IllegalStateException("student id"+userid+"not exist");
                }

                userrepo.deleteById(userid);
                return userid;

            }

        //@Transactional
        //    public void updateStudent(Long studentid, String name, String email) {
        //
        //
        //        boolean idexis = studentrepo.existsById(studentid);
        //        if(!idexis)
        //
        //            {
        //                throw new IllegalStateException("student id"+studentid+"not exist");
        //            }
        //
        //
        //    List<Student> student = getStudent();
        //
        //        System.out.println(student);
        ////    if(name!=null && name.length()>0 && !Object.equals(student.getName(),name))
        ////        {
        ////            student.setname(name);
        ////        }
        //
        //}

            public User updateUser(User user) {

                int idv=user.getId();
                boolean existf = userrepo.existsById( idv);

                if(!existf)
                {
                    throw new IllegalStateException(idv+"not exist");
                }

                userrepo.save(user);
                return user;

            }
        }

