package com.example.crudd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired private IStudentRepository repo;

    public List<students> listAll(){
        return (List<students>) repo.findAll();
    }



    public void save (students student){
        repo.save(student);
    }

    public students get(Integer id) throws UserNotFoundException {
        Optional<students> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not found Students"+
                id);
    }
    public  void delete (Integer id) throws UserNotFoundException {
      Long count =  repo.countById(id);
      if (count ==null ||count==0){
          throw new UserNotFoundException("Could not found Students"+id);
      }
        repo.deleteById(id);
    }
}
