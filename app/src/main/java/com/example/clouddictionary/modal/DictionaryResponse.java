package com.example.clouddictionary.modal;


import java.util.ArrayList;

public class DictionaryResponse
{
    private License license;

    private ArrayList<Phonetics> phonetics;

    private String word;

    private ArrayList<Meanings> meanings;

    private ArrayList<String> sourceUrls;

    public License getLicense ()
    {
        return license;
    }

    public void setLicense (License license)
    {
        this.license = license;
    }

    public ArrayList<Phonetics> getPhonetics ()
    {
        return phonetics;
    }

    public void setPhonetics (ArrayList<Phonetics> phonetics)
    {
        this.phonetics = phonetics;
    }

    public String getWord ()
    {
        return word;
    }

    public void setWord (String word)
    {
        this.word = word;
    }

    public ArrayList<Meanings> getMeanings ()
    {
        return meanings;
    }

    public void setMeanings (ArrayList<Meanings> meanings)
    {
        this.meanings = meanings;
    }

    public ArrayList<String> getSourceUrls ()
    {
        return sourceUrls;
    }

    public void setSourceUrls (ArrayList<String> sourceUrls)
    {
        this.sourceUrls = sourceUrls;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [license = "+license+", phonetics = "+phonetics+", word = "+word+", meanings = "+meanings+", sourceUrls = "+sourceUrls+"]";
    }

    public class License
    {
        private String name;

        private String url;

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [name = "+name+", url = "+url+"]";
        }
    }

    public class Meanings
    {
        private ArrayList<String> synonyms;

        private String partOfSpeech;

        private ArrayList<String> antonyms;

        private ArrayList<Definitions> definitions;

        public ArrayList<String> getSynonyms ()
        {
            return synonyms;
        }

        public void setSynonyms (ArrayList<String> synonyms)
        {
            this.synonyms = synonyms;
        }

        public String getPartOfSpeech ()
        {
            return partOfSpeech;
        }

        public void setPartOfSpeech (String partOfSpeech)
        {
            this.partOfSpeech = partOfSpeech;
        }

        public ArrayList<String>getAntonyms ()
        {
            return antonyms;
        }

        public void setAntonyms (ArrayList<String> antonyms)
        {
            this.antonyms = antonyms;
        }

        public ArrayList<Definitions> getDefinitions ()
        {
            return definitions;
        }

        public void setDefinitions (ArrayList<Definitions> definitions)
        {
            this.definitions = definitions;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [synonyms = "+synonyms+", partOfSpeech = "+partOfSpeech+", antonyms = "+antonyms+", definitions = "+definitions+"]";
        }
    }
    public class Definitions
    {
        private ArrayList<String> synonyms;

        private ArrayList<String> antonyms;

        private String definition;

        public ArrayList<String> getSynonyms ()
        {
            return synonyms;
        }

        public void setSynonyms (ArrayList<String> synonyms)
        {
            this.synonyms = synonyms;
        }

        public ArrayList<String> getAntonyms ()
        {
            return antonyms;
        }

        public void setAntonyms (ArrayList<String> antonyms)
        {
            this.antonyms = antonyms;
        }

        public String getDefinition ()
        {
            return definition;
        }

        public void setDefinition (String definition)
        {
            this.definition = definition;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [synonyms = "+synonyms+", antonyms = "+antonyms+", definition = "+definition+"]";
        }
    }

    public class Phonetics
    {
        private String sourceUrl;

        private License license;

        private String audio;

        public String getSourceUrl ()
        {
            return sourceUrl;
        }

        public void setSourceUrl (String sourceUrl)
        {
            this.sourceUrl = sourceUrl;
        }

        public License getLicense ()
        {
            return license;
        }

        public void setLicense (License license)
        {
            this.license = license;
        }

        public String getAudio ()
        {
            return audio;
        }

        public void setAudio (String audio)
        {
            this.audio = audio;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [sourceUrl = "+sourceUrl+", license = "+license+", audio = "+audio+"]";
        }
    }





}